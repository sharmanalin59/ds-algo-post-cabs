import org.junit.Assert;
import org.junit.Test;
import rate.limiter.LeakyBucket;
import rate.limiter.TokenBucket;

/**
 * @author nalin.sharma on 16/10/21
 */
public class RateLimiterTest {

    @Test
    public void test_bucket_token() {
        try {
        TokenBucket tb = new TokenBucket(10, 50);

        Thread.sleep(6000);

        int i = 0;
        while(tb.allow()) {
            i++;
        }
        Assert.assertEquals(50, i);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_leaky_bucket() {
        try {
        LeakyBucket lb = new LeakyBucket(10);
        Thread.sleep(5000);

        int i = 0;
        while(lb.allow()) {
            i++;
            System.out.println(i);
            if(i < 10)
            Thread.sleep(100);
        }
        Assert.assertEquals(10, i);

    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    }
}
