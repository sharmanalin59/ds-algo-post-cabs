package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

/**
 * @author nalin.sharma on 03/08/21
 */
public class ArcesiumCopy {
    enum Day {
        mon(1);

        private Day(int i) {
            this.value= i;
        }
        private int value;
        }
    public static List<Integer> apiResponseParser(List<String> inputList, int size) {
        List<Integer> out = new ArrayList<>();
        String inputLine = "";
        BufferedReader br;
        InputStream in;
        try {

            String urlString = "https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users";
            URL url = new URL(urlString);
            URLConnection conn = url.openConnection();
            in = conn.getInputStream();
            br = new BufferedReader(new InputStreamReader(in));

            String op = inputList.get(1);

            String matchKey1 = "", matchKey2 = "";
            boolean matchedKey1 = false, matchedKey2 = false;
            String arr [] = inputList.get(0).split("\\.");
            if(arr.length == 1) {
                matchKey2 = arr[0];
                matchedKey2 = false;
            }
            else if(arr.length == 2) {
                matchKey1 = arr[0];
                matchKey2 = arr[1];
            }

            //validation op
            if(!op.equals("EQUALS") && !op.equals("IN")) {
                br.close();
                in.close();
                out.add(-1);
                return out;
            }

            Set<String> matchVal = new HashSet<>();
            String str1 [] = inputList.get(2).split("\\,");
            for(int i = 0; i < str1.length; i++) {
                matchVal.add(str1[i]);
            }

            Integer curId = -1;
            while((inputLine = br.readLine()) != null) {
                if(inputLine.length() < 5) {
                    continue;
                }
                String [] str = inputLine.split(":");
                if(str[0].contains("\"id\"")) {
                    curId = Integer.parseInt(str[1].substring(0, str[1].length()-1).trim());
                    matchedKey1 = false;
                    matchedKey2 = false; // "".equals(matchKey2);
                    continue;
                }

                if(!matchedKey1 && str[0].contains(matchKey1)) {
                    matchedKey1 = true;
                    if(matchedKey2 && matchVal.contains(str[1].substring(1, str[1].length() - 2).replaceAll("[^a-zA-Z0-9.@-]", ""))) {
                        out.add(curId);
                    }
                }
                else if(matchedKey1 && !matchedKey2 && str[0].contains(matchKey2)) {
                    matchedKey2 = true;
                    String val = str[1].substring(1, str[1].length() - 2).replaceAll("[^a-zA-Z0-9.@-]", "");
                    if(matchVal.contains(val)) {
                        out.add(curId);
                    }
                }
            }
            br.close();
            in.close();
        }
        catch(IOException e) {}
        catch(Exception e) {System.out.println("Exception");}

        if(out.size() == 0) {
            out.add(-1);
        }
        System.out.println(inputList.get(0) +" "+inputList.get(1)+" "+inputList.get(2)+" "+out);

        return out;
    }

    public static void main(String[] args) {
        //System.out.println(apiResponseParser(Arrays.asList("address.city","IN","Bengaluru,Mumbai"), 3));

        //System.out.println(apiResponseParser(Arrays.asList("username","EQUALS","vinayk"), 3));
        //System.out.println(apiResponseParser(Arrays.asList("address.city","EQUALS","Surat"), 3));
        System.out.println(apiResponseParser(Arrays.asList("username","EQUALS","Wilsonp"), 3));
    }
}
