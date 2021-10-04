package hackerrank;

import java.io.*;
import java.util.*;

/**
 * @author nalin.sharma on 10/06/21
 */
public class Candies {

    public static long candies(int n, List<Integer> arr) {
        // Write your code here
        int[] dis = new int[n];
        int cnt = 1;
        for(int i = 1; i < n; i++) {
            if(arr.get(i) > arr.get(i-1)) {
                if(cnt == 1) {
                    dis[i-1] = 1;
                }
                cnt++;
                dis[i] = cnt;
            }
            else if(arr.get(i) == arr.get(i-1)) {
                if(dis[i-1] == 0) {
                    dis[i - 1] = dis[i] = 1;
                }
                else {
                    dis[i] = 1;
                }
                cnt = 1;
            }
            else {
                cnt = 1;
            }
        }

        cnt = 1;
        for(int i = n - 2; i >= 0; i--) {
            if(arr.get(i) > arr.get(i + 1)) {
                if(cnt == 1) {
                    dis[i+1] = 1;
                }
                cnt++;
                if(dis[i] == 0) {
                    dis[i] = cnt;
                }
                else {
                    cnt = 1;
                }
            }
            else {
                cnt = 1;
            }
        }

        for(int i = 0; i < n - 1; i++) {
            if(arr.get(i) > arr.get(i+1) && dis[i] <= dis[i+1]) {
                dis[i] = dis[i+1] + 1;
            }
        }

        Arrays.stream(dis).filter(i -> i == 0).forEach(System.out::println);
        return Arrays.stream(dis).sum();
    }

    /**
     *
     * 59801
     * 2225
     * 51489
     * 63693
     * 65074
     * 30389
     * 92493
     * 49135
     * 83523
     * 37766
     * 16728
     * 74433
     * 64881
     * 4280
     * 93171
     * 91649
     * 85163
     * 61161
     * 47441
     * 47265
     * 17338
     * 85194
     * 51669
     * 17817
     *
     * 2  4  2  6  1  7  8  9  2  1
     * 1  2  1  2  1  2  3  4  2  1
     *
     */
    public static void main(String[] args) throws IOException {
        List<Integer> rank = new ArrayList<>();
        /*rank.add(2);
        rank.add(4);
        rank.add(2);
        rank.add(6);
        rank.add(1);
        rank.add(7);
        rank.add(8);
        rank.add(9);
        rank.add(2);
        rank.add(1);*/

        //Properties prop = readPropertiesFile("src/main/java/hackerrank/property.txt");
        //Enumeration v = prop.propertyNames();

        /*while (v.hasMoreElements()) {
        //    System.out.println(v.nextElement());
            rank.add(Integer.parseInt((String)v.nextElement()));
        }*/

        try {
            File myObj = new File("src/main/java/hackerrank/property.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                rank.add(Integer.parseInt(data));
                //System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < rank.size(); i++) {
            if(!map.containsKey(rank.get(i))) {
                map.put(rank.get(i), 1);
            }
            else {
                map.put(rank.get(i), map.get(rank.get(i)) + 1);
            }
        }

        map.forEach((k,val) -> {
            if(val > 1) {
                ;//System.out.println(k+" "+val);
            }
        });

        System.out.println(candies(rank.size(), rank));
    }

    public static Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;

    }

}
