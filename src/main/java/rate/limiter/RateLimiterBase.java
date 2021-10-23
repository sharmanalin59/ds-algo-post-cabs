package rate.limiter;

/**
 * @author nalin.sharma on 16/10/21
 */
public abstract class RateLimiterBase {
    public RateLimiterBase(int reqPerSec) {
        this.reqPerSec = reqPerSec;
    }

    private int reqPerSec;

    public int getReqPerSec() {
        return reqPerSec;
    }

    public abstract boolean allow();
}
