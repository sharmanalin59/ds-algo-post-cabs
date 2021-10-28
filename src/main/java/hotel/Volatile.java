package hotel;

/**
 * @author nalin.sharma on 08/07/21
 */
public class Volatile {
    //private static final Logger LOGGER = MyLoggerFactory.getSimplestLogger();

    private static volatile int MY_INT = 0;

    public static void main(String[] args) {
        new ChangeListener().start();
        new ChangeMaker().start();

    }

    static class ChangeListener extends Thread {
        @Override
        public void run() {
            int local_value = MY_INT;
            while ( local_value < 5){
                //System.out.println("reader :"+MY_INT);
                if( local_value!= MY_INT){
                    System.out.println("Got Change for MY_INT : "+ MY_INT);
                    local_value= MY_INT;
                }
                /*try {
                    Thread.sleep(0,1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        }
    }

    static class ChangeMaker extends Thread{
        @Override
        public void run() {

            int local_value = MY_INT;
            while (MY_INT <5){
                System.out.println("Incrementing MY_INT to "+ (local_value+1));
                MY_INT = ++local_value;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        }
    }
}
