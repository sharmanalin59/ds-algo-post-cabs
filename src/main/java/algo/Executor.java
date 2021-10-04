/*
package algo;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Executor {
    static class Job<T> implements Runnable {
        String thread;
        Job(String t) {
            thread = t;
        }

        @Override
        public void run()  {
            int i = 1;
            while(i < 20) {
                System.out.println(thread+ i++);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor worker = new ThreadPoolExecutor(1, Runtime.getRuntime().availableProcessors() * 4, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(1),
                new ThreadFactoryBuilder().setNameFormat("job-worker-%d").build());
        worker.execute(new Job<Integer>("Nalin"));
        worker.execute(new Job<Integer>("Nipun"));
        worker.execute(new Job<Integer>("Sarthak"));
        //worker.execute(new Job<Integer>("Yashu"));
        //worker.execute(new Job<Integer>("Jayati"));
       */
/* Collection<Job<Integer>> c = new ArrayList<>();
        c.add(new Job<Integer>("Nalin"));
        c.add(new Job<Integer>("Nipun"));
        c.add(new Job<Integer>("Sarthank"));
        worker.invokeAll(c);*//*

        //worker.invokeAll((Collection<Callable<? extends Object>>) Arrays.asList(new Job<Integer>("Nalin"), new Job<Integer>("Nipun"), new Job<Integer>("Sarthak")));
        System.out.println("execute");
        System.out.println("execute");
    }
}
*/
