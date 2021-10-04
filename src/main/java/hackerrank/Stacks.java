package hackerrank;

import java.io.*;
import java.io.IOException;
import java.net.*;
import java.util.*;
import java.util.stream.Collectors;

public class Stacks {
    static void connection() throws IOException {
        URL url = new URL("https://hr-testcases-us-east-1.s3.amazonaws.com/33183/input02.txt?AWSAccessKeyId=AKIAR6O7GJNX5DNFO3PV&Expires=1619477602&Signature=8CqyxFgOS84faruM2F7d0%2FDqscw%3D&response-content-type=text%2Fplain");
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        String result = new BufferedReader(new InputStreamReader(is))
                .lines().collect(Collectors.joining("\n"));
        System.out.println(result);


        URL oUrl = new URL("https://hr-testcases-us-east-1.s3.amazonaws.com/33183/output02.txt?AWSAccessKeyId=AKIAR6O7GJNX5DNFO3PV&Expires=1619477617&Signature=4%2FCUxJJNlJJYzGGsDRFVxMzYVIY%3D&response-content-type=text%2Fplain");
        URLConnection oConn = oUrl.openConnection();
        InputStream oIs = oConn.getInputStream();
        String outputResult = new BufferedReader(new InputStreamReader(oIs))
                .lines().collect(Collectors.joining("\n"));
        System.out.println(outputResult);

        check_tests(result,outputResult);

    }

    static List<Integer> convert(String... list) {
        List<Integer> l = new LinkedList<>();
        for(int i = 0; i < list.length; i++) {
            l.add(Integer.parseInt(list[i]));
        }
        return l;
    }

    private static void check_tests(String result, String outputResult) {
        String line [] = result.split("\n");
        String output [] = outputResult.split("\n");
        int out = 0;
        int s = 0, f = 0;
        for(int i = 1; i < line.length; i+=3) {
            int sum = Integer.parseInt(line[i].split(" ")[2]);
            String input1 [] = line[i+1].split(" ");
            String input2 [] = line[i+2].split(" ");
            try {
                List<Integer> l1 = convert(input1);
                List<Integer> l2 = convert(input2);
                int mine = twoStacks(sum, l1, l2);
                if (Integer.parseInt(output[out++]) != mine) {
                    System.out.println("Failed mine:"+mine+" Expected:"+output[out-1]+" Test case:"+line[i]);
                    f++;
                }
            else {
                    System.out.println("Success");
                    s++;
                }
            }catch (Exception e) {
                System.out.println(i+" failedddd");
            }
        }
        System.out.println("Failed: "+f+" Succeeded: "+s);
    }

    // 1 ,0 ,1 ,1 ,0 ,0 ,1 ,1 ,1 ,0 ,1 ,0 ,1 ,1 ,0 ,0 ,0 ,0 ,1 ,0 ,0 ,1 ,
    // 0 ,1 ,0 ,1 ,0 ,0 ,1 ,0 ,
    // 0 ,1 ,0
    //
    // ,1 ,0 ,1 ,0 ,1 ,0 ,1 ,1 ,1 ,0
    //43
    // <-> 0 ,0 ,0 ,1 ,0 ,0 ,0
    /*

     */
    public static void main(String[] args) throws IOException {
        //connection();
        Integer [] a1 = {1 ,0 ,1 ,1 ,0 ,0 ,1 ,1 ,1 ,0 ,1 ,0 ,1 ,1 ,0 ,0 ,0 ,0 ,1 ,0 ,0 ,1 ,0 ,1 ,0 ,1 ,0 ,0 ,1 ,0 ,0 ,1 ,0 ,1 ,0 ,1 ,0 ,1 ,0 ,1 ,1 ,1 ,0};
        Integer [] a2 = {0 ,0 ,0 ,1 ,0 ,0 ,0};
        List<Integer> l1 = new LinkedList<>(Arrays.asList(a1));
        List<Integer> l2 = new LinkedList<>(Arrays.asList(a2));
        System.out.println(twoStacks(15,l1,l2));
    }

    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        // Write your code here
        Deque<Integer> aQ = (Deque<Integer>) a;
        Deque<Integer> bQ = (Deque<Integer>) b;
        Deque<Integer> cQ = new LinkedList<>();
        int sum = 0, cnt = 0, bInd = 1, maxCnt = 0;
        while(!aQ.isEmpty()) {
            if(sum + aQ.peekFirst() <= maxSum){
                cQ.add(aQ.peekFirst());
                sum += aQ.remove();
            }
            else {
                break;
            }
        }
        maxCnt = cnt = cQ.size();
        //aQ = new LinkedList<>(cQ);

        while(!bQ.isEmpty()) {
            while(!bQ.isEmpty() && (sum + bQ.peekFirst() <= maxSum)) {
                sum += bQ.remove();
                cnt++;
            }
            if(maxCnt < cnt) {
                maxCnt = cnt;
            }
            if(bQ.isEmpty()) {
                break;
            }
            sum += bQ.remove();
            cnt++;

            while(!cQ.isEmpty() && (sum - cQ.peekLast() > maxSum)) {
                sum -= cQ.removeLast();
                cnt--;
            }
            if(!cQ.isEmpty()){
                sum -= cQ.removeLast();
                cnt--;
            }
            else {
                break;
            }
        }
        return maxCnt;
    }
}
