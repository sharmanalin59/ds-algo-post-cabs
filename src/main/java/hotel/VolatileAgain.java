package hotel;

import edu.emory.mathcs.backport.java.util.Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nalin.sharma on 08/07/21
 */
public class VolatileAgain {

    static int[] l = {0,1,2};
    static int var = 0;
    static class Reader implements Runnable {

        @Override
        public void run() {
            do {
                System.out.println();
                /*for(int i = 0; i < l.length; i++) {
                System.out.print(l[i]+" ");
                }*/
                System.out.print("\n"+var);
                }while(l[0] != 4);
            }
    }

    static class Writer implements Runnable {

        @Override
        public void run() {
            int i = 0;
            while(i < 4) {
                l[0] += 1;
                i++;
                var++;
                System.out.println("Written");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        (new Thread(new Reader())).start();
        (new Thread(new Writer())).start();
    }
}
