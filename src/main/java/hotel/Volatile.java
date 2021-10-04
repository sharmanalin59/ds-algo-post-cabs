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

        /*double arr[] = {
                0.0144,
                0.0166571,
                0.0166571,
                0.0166571,
                0.0166571,
                0.0166571,
                0.0166571,
                0.0166571,
                0.0166571,
                0.0166571,
                0.0166571,
                0.0166571,
                0.0166571,
                0.0166571,
                0.0166577,
        };
        double sophia = 0.0144 + (13 * 0.0166571) + 0.0166577; //0.24760000000000001
        double sophia_wazir = sophia + (15 * (0.0006)); //0.2566
        System.out.println("sophia "+sophia+" sophia wazirx "+sophia_wazir);

        double kate = 0.0157 + 0.1071;
        double kate_wazir = kate + (2 * (0.0006)); //0.12279999999999999
        System.out.println("kate "+kate+" kate wazirx "+kate_wazir);

        double williams = 0.0243 + 0.0249 + 0.0629;
        double williams_wazir = williams + (3 * (0.0006)); //0.11209999999999999
        System.out.println("williams "+williams+" williams wazirx "+williams_wazir);

        double matty = 0.0006 + 0.0018;
        double matty_wazir = williams + (2 * (0.0006)); //0.11209999999999999
        System.out.println("matty "+matty+" matty wazirx "+matty_wazir);

        double total = sophia + kate + williams + matty;
        double totalWazirX = sophia_wazir + kate_wazir + williams_wazir + matty_wazir;
        System.out.println("total "+total+" total wazirx "+totalWazirX);*/
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
