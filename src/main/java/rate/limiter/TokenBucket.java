package rate.limiter;

/**
 * @author nalin.sharma on 16/10/21
 */
public class TokenBucket extends RateLimiterBase {

    int MAX_TOKEN = 100;
    int current_token = 0;
    long lastReqAt;

    public TokenBucket(int reqPerSec, int MAX_TOKEN) {
        super(reqPerSec);
        this.MAX_TOKEN = MAX_TOKEN;
        lastReqAt = System.currentTimeMillis();
    }

    @Override
    public boolean allow() {
        long cur = System.currentTimeMillis();
        synchronized (this) {
            refill(cur - lastReqAt, getReqPerSec());
            lastReqAt = cur;
            if(current_token >= 1) {
                current_token--;
                return true;
            }
            return false;
        }
    }

    synchronized private void refill(long gap, int reqPerSec) {
        current_token = Math.min((int)(current_token + (gap * reqPerSec/1000)), MAX_TOKEN);
    }
}
