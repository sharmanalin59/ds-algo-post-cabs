/**
 * @author nalin.sharma on 17/09/21
 *
 *  0 1 1 2 3 5 8 11
 *      f+s
 *        f+2s
 *            2f+3s
 *                 3f+5s
 *                      5f+8s
 *                           8f+13s
 *  T(n) = T(n-1) + T(n-2)
 *       = 2 * T(n-2) + T(n-3)
 *       = 2 * T(n-2) + T(n-3)
 */
public class Fib {
    public static void main(String[] args) {
        int first = 0, second = 1, third;
        int n = 3, i = 0;
    }
}
