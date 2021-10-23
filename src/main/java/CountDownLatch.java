import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author nalin.sharma on 11/10/21
 */
public class CountDownLatch {
    static class CDL {
        public CDL(Integer latch) {
            this.latch = latch;
        }

        Integer latch;
        synchronized void countDown() {
            if (latch > 0) {
                latch--;
            }
            if(latch == 0) {
                this.notify();
            }
        }
        synchronized void latch() {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class Worker implements Runnable {
        Worker(String t, CDL c) {
            type = t;
            cdl = c;
        }
        String type;
        CDL cdl;
        @Override
        public void run() {
            //do some work
            System.out.println(type+" start");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(type+" end");
            cdl.countDown();
        }
    }

    static class Master implements Runnable {
        public Master(CDL cdl) {
            this.cdl = cdl;
        }

        CDL cdl;
        @Override
        public void run() {
            System.out.println("Master start");
            cdl.latch();
            System.out.println("Master end");
        }
    }
    public static void main(String[] args) {
        CDL cdl = new CDL(3);
        Thread waiter = new Thread(new Worker("Waiter", cdl));
        Thread cleaner = new Thread(new Worker("Cleaner", cdl));
        Thread cook = new Thread(new Worker("Cook", cdl));
        Thread master = new Thread(new Master(cdl));

        master.start();
        waiter.start();
        cleaner.start();
        cook.start();
    }
}
