/**
 * @author nalin.sharma on 03/09/21
 */
public class ThreadStop {

    static class JustWaitJob implements Runnable {

        @Override
        public void run() {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interupted runing");
            }
            try {
            while(!Thread.currentThread().isInterrupted()) {
                System.out.println("waiting / / /");
                Thread.sleep(5000);
                /*try {
                    synchronized (this) {
                        System.out.println("waiting.." + Thread.currentThread().isInterrupted());
                        this.wait();
                    }
                    System.out.println("Interupted waiting");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
            //System.out.println("waiting over..");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class WaitJob implements Runnable {

        @Override
        public void run() {
            try {
                synchronized (this) {
                    System.out.println("waiting..");
                    this.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("waiting over..");
        }
    }
    static class SleepJob implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("sleeping..");
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sleeping over..");
        }
    }
    static class NormalJob implements Runnable {

        volatile boolean run = true;
        void stop() {
            run = false;
        }
        @Override
        public void run() {
            while(run) {
                try {
                    System.out.println("running..");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("running over..");
        }
    }
    public static void main(String[] args) throws InterruptedException{
        /*NormalJob normalJob = new NormalJob();
        Thread waitThread = new Thread(new WaitJob());
        Thread sleepThread = new Thread(new SleepJob());
        Thread runThread = new Thread(normalJob);

        waitThread.start();
        sleepThread.start();
        runThread.start();

        Thread.sleep(4000);
        System.out.println("calling interrupt..");
        waitThread.interrupt();
        sleepThread.interrupt();
        runThread.interrupt();

        System.out.println("stopping normal..");
        normalJob.stop();*/

        JustWaitJob justWaitJob = new JustWaitJob();
        Thread waitThread = new Thread(justWaitJob);
        waitThread.start();
        Thread.sleep(2000);
        waitThread.interrupt();
    }
}
