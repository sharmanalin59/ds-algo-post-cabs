package rate.limiter;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author nalin.sharma on 16/10/21
 */
public class FixedWindow extends RateLimiterBase {

    ConcurrentHashMap<Long, AtomicInteger> map = new ConcurrentHashMap<>();

    public FixedWindow(int reqPerSec) {
        super(reqPerSec);
    }

    @Override
    public boolean allow() {
        long key = System.currentTimeMillis()/1000;
        map.putIfAbsent(key, new AtomicInteger(0));
        return map.get(key).incrementAndGet() <= getReqPerSec();
    }

    /*public static void main(String[] args) {
        System.out.println(System.currentTimeMillis()/1000);
        System.out.println(System.currentTimeMillis()/1000);
        System.out.println(System.currentTimeMillis()/1000);
    }*/
}
