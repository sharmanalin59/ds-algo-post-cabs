package algo.thoughtspot;

public class Solution1 {
    public static void main(String[] args) {
        int n=3;
        if(n>=1 && n<=100){
            if(n%2==1){
                System.out.println("Weird");
            }
            if((n%2==0) && n>=2 && n<=5){
                System.out.println("Not Weird");
            }

            if((n%2==0) && n>=6 && n<=20){
                System.out.println("Weird");
            }

            if((n%2==0) && n>20){
                System.out.println("Not Weird");
            }


        }

    }
}
