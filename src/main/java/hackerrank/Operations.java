package hackerrank;

import java.util.*;

public class Operations {
    static void del(StringBuilder str, int cnt) {
        while(cnt  > 0) {
            str.deleteCharAt(str.length()-1);
            cnt--;
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        StringBuilder test = new StringBuilder();
        test.append("a");
        test.append("\n");
        test.append("b");
        System.out.println(test);

        Scanner scan = new Scanner(System.in);
        int cnt = Integer.parseInt(scan.nextLine());
        String[] op;
        StringBuilder builder = new StringBuilder(Integer.MAX_VALUE);
        Deque<String> stack = new LinkedList<>();
        while(cnt > 0) {
            String s = scan.nextLine();
            op = s.split(" ");
            if(op[0].equals("1")) {
                builder.append(op[1]);
                stack.push("2#"+op[1].length());
            }
            else if(op[0].equals("2")) {
                int len = Integer.parseInt(op[1]);
                String del = builder.substring(builder.length()-len, builder.length());
                del(builder, len);
                stack.push("1#"+del);
            }
            else if(op[0].equals("3")) {
                int ind = Integer.parseInt(op[1]);
                System.out.println(builder.charAt(ind-1));
            }
            else if(op[0].equals("4")) {
                if(!stack.isEmpty()) {
                    String[] toBeDone = stack.pop().split("#");
                    if(toBeDone[0] == "1") {
                        builder.append(toBeDone[1]);
                    }
                    else if(toBeDone[0] == "2") {
                        int len = Integer.parseInt(toBeDone[1]);
                        del(builder, len);
                    }
                }
            }
            cnt--;
        }
        System.out.println("Boolean Result: " + scan.hasNext());
    }
}
