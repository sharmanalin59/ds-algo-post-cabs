import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author nalin.sharma on 26/08/21
 */
public class Cars24P2 {
    static class ThreadPool {

        static class ThreadTask implements Runnable {
            ThreadTask(int maxThreads, boolean[] stopService) {
                this.maxThreads = maxThreads;
                this.stopService = stopService;
            }
            int maxThreads;
            boolean stopService [];
            @Override
            public void run() {
                while(!stopService[0]) {
                    Runnable runnable = taskQueue.poll();
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            }
        }

        //static Object mutex = new Object();
        boolean [] stopService = {false};
        void stopService() {
            stopService[0] = true;
        }
        static AtomicInteger runningThreadCnt = new AtomicInteger();
        ThreadPool(int initialThreads, int maxThreads) {
            if(initialThreads <= 0) {
                throw new RuntimeException("inital threads cant be negative o 0");
            }
            this.initialThreads = initialThreads;
            this.maxThreads = maxThreads;
            init();
        }

        private void init() {
            IntStream.range(0, initialThreads).forEach(ind -> {
                Thread t = new Thread(threadTask);
                threadQueue.add(t);
                t.start();
            });
        }

        int initialThreads, maxThreads;
        static BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();
        static Queue<Thread> threadQueue = new LinkedList<>();
        ThreadTask threadTask = new ThreadTask(maxThreads, stopService);

        void submitTask(Runnable runnable) throws InterruptedException {
            taskQueue.put(runnable);
            Thread.sleep(10);
            if(taskQueue.size() > 0 && threadQueue.size() < maxThreads) {
                System.out.println("new task arrived, current threads active "+threadQueue.size()+" scaling up");
                Thread t = new Thread(threadTask);
                threadQueue.add(t);
                t.start();
                System.out.println("new current threads active "+threadQueue.size());
            }
        }


    }

    public static void main(String[] args) throws InterruptedException {
        ThreadPool tp = new ThreadPool(1,3);
        class Task implements Runnable{
            Task(int c) {
                cnt = c;
            }
            int cnt;
            @Override
            public void run() {
                System.out.println(" my task " + cnt + " executing..");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(" my task " + cnt + " ended..");
            }
        }
        tp.submitTask(new Task(1));
        tp.submitTask(new Task(2));
        tp.submitTask(new Task(3));
        tp.submitTask(new Task(4));
        tp.submitTask(new Task(5));
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tp.stopService();
    }
}
