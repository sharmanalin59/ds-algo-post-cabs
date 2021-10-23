/**
 * @author nalin.sharma on 13/10/21
 */
public class SAP1 {

    static class EvenJob implements Runnable {

        EvenJob(Object mutex) {
            this.mutex = mutex;
        }
        Object mutex;

        @Override
        public void run() {
            synchronized (mutex) {
                int val = 1;
                while(true) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+ " " +val);
                        /*if(val == 1) {
                            new Thread(new OddJob(mutex)).start();
                        }*/
                        val += 2;
                        mutex.notify();
                        mutex.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class OddJob implements Runnable {

        public OddJob(Object mutex) {
            this.mutex = mutex;
        }

        Object mutex;
        @Override
        public void run() {
            synchronized (mutex) {
                int val = 2;
                while(true) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+ " " +val);
                        val += 2;
                        mutex.notify();
                        mutex.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Object mutex = new Object();
        new Thread(new EvenJob(mutex)).start();
            //thread.sleep
        Thread.sleep(100);
        new Thread(new OddJob(mutex)).start();
    }
}
