package rate.limiter;

/**
 * @author nalin.sharma on 16/10/21
 */
public class LeakyBucket extends RateLimiterBase {

    long lastReqAt;
    long timeInterval;

    public LeakyBucket(int reqPerSec) {
        super(reqPerSec);
        timeInterval = 1000 / getReqPerSec();
        lastReqAt = System.currentTimeMillis();
    }

    @Override
    public boolean allow() {
        long cur = System.currentTimeMillis();
        synchronized (this) {
            if (cur - lastReqAt >= timeInterval) {
                System.out.println("dff :"+(cur - lastReqAt));
                lastReqAt = cur;
                return true;
            }
            return false;
        }
    }
}
