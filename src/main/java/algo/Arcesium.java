package algo;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * @author nalin.sharma on 03/08/21
 */
public class Arcesium {
    enum Day {
        mon(1);

        private Day(int i) {
            this.value= i;
        }
        private int value;
        }
    public static List<Integer> apiResponseParser(List<String> inputList, int size) {

        String [][] a = new String [2][2];
        System.out.println("a.."+ Day.valueOf("mon").value);
        String inputLine = "";
        StringBuilder res = new StringBuilder();
        List<Integer> out = new ArrayList<>();
        try {
            String urlString = "https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users";
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            InputStream in = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));


            String op = inputList.get(1);
            String matchKey1 ="", matchKey2 = "";
            boolean matchedKey1 = false, matchedKey2 = false;
            /*if(inputList.get(0).indexOf(".") != -1) {
                String arr [] = inputList.get(0).split("\\.");
                matchKey1 = arr[0];
                matchedKey1 = false;
                matchKey2 = arr[1];
                matchedKey2 = "".equals(matchKey2);
            }
            else {
                matchKey1 = inputList.get(0);
                matchKey2 = "";
            }*/
            String arr [] = inputList.get(0).split("\\.");
            if(arr.length == 1) {
                matchKey2 = arr[0];
                matchedKey1 = true;
            }
            else if(arr.length == 2) {
                matchKey1 = arr[0];
                matchKey2 = arr[1];
            }

            if(!op.equals("EQUALS") && !op.equals("IN")) {
                out.add(-1);
                return out;
            }

            Set<String> matchVal = new HashSet<>();
            String str1 [] = inputList.get(2).split("\\,");
            for(int i = 0; i < str1.length; i++) {
                matchVal.add(str1[i]);
            }
            Integer curId = -1;
            while(((inputLine = br.readLine()) != null)) {
                if(inputLine.length() <5) {
                    continue;
                }
                res.append(inputLine);
                String [] str = inputLine.split(":");
                if(str[0].contains("\"id\"")) {
                    curId = Integer.parseInt(str[1]
                            .substring(0,str[1].length() - 1)
                            .trim());
                    matchedKey1 = false;
                    matchedKey2 = "".equals(matchKey2);
                    continue;
                }

                if(!matchedKey1 && str[0].contains(matchKey1)) {
                    matchedKey1 = true;
                    if(matchedKey2 &&
                            matchVal.contains(
                                    str[1]
                                            .substring(1, str[1].length() - 2)
                                            .replaceAll("[^a-zA-Z0-9.@-]", ""))) {
                        out.add(curId);
                    }
                }
                else if(matchedKey1 && !matchedKey2 && str[0].contains(matchKey2)) {
                    matchedKey2 = true;
                    String val = str[1].substring(1, str[1].length() - 2)
                            .replaceAll("[^a-zA-Z0-9.@-]","");
                    if(matchVal.contains(val)) {
                        out.add(curId);
                    }
                }

            }
            br.close();

        }
        catch(IOException e) {

        }
        System.out.println(res);

        return out;
    }

    public static void main(String[] args) {
        //System.out.println(apiResponseParser(Arrays.asList("address.city","IN","Bengaluru,Mumbai"), 3));

        //System.out.println(apiResponseParser(Arrays.asList("username","EQUALS","vinayk"), 3));
        System.out.println(apiResponseParser(Arrays.asList("address.city","EQUALS","Surat"), 3));
        System.out.println(apiResponseParser(Arrays.asList("username","EQUALS","WilsonP"), 3));
    }
}
