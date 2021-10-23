package rate.limiter;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author nalin.sharma on 16/10/21
 */
public class SlidingWindow extends RateLimiterBase {
    Deque<Long> stack = new LinkedList<>();

    public SlidingWindow(int reqPerSec) {
        super(reqPerSec);
    }

    @Override
    public boolean allow() {
        Long lastReqAt = System.currentTimeMillis();
        Long boundary = lastReqAt - 1000;
        synchronized (stack) {
            while(!stack.isEmpty() && stack.peek() <= boundary) {
                stack.pop();
            }
            stack.push(lastReqAt);
            return stack.size() <= getReqPerSec();
        }
    }
}
