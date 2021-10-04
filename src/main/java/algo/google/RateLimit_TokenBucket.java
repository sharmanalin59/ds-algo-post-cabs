package algo.google;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author nalin.sharma on 22/07/21
 */
public class RateLimit_TokenBucket {
    static class RateLimiter {
        double rate_per_sec = 3;
        long lastUpdate = new Date().getTime();
        long tokens = 0;
        long size = 50;

        //Main method
        synchronized boolean grantRequest(int tokenRequested) {
            long now = new Date().getTime();
            // add token
            tokens = Math.min(tokens + (long)rate_per_sec * (now - lastUpdate)/1000, size);
            System.out.println("Tokens updated to :"+tokens);
            lastUpdate = now;
            if(tokens >= tokenRequested) {
                tokens -= tokenRequested;
                System.out.println("Tokens remaining :"+tokens);
                return true;
            }
            System.out.println("Tokens remaining :"+tokens);
            return false;
        }
    }
    static class Job implements Runnable {
        RateLimiter rateLimiter;
        Job(RateLimiter rateLimiter) {
            this.rateLimiter = rateLimiter;
        }
        @Override
        public void run() {
            while(true) {
                Random r = new Random();
                int num = ThreadLocalRandom.current().nextInt(1, 5 + 1);
                try {
                    Thread.sleep(num*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                num = ThreadLocalRandom.current().nextInt(1, 50 + 1);
                System.out.println(Thread.currentThread().getName()
                        + " requesting " + num + " granted :" + rateLimiter.grantRequest(num));
            }
        }
    }
    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter();
        Job job = new Job(rateLimiter);
        new Thread(job,"A").start();
        new Thread(job, "B").start();
    }
}
