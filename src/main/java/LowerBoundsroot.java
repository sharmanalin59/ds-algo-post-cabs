/**
 * @author nalin.sharma on 02/09/21
 */
public class LowerBoundsroot {
    public static void main(String[] args) {
        int n = 1000;
        int a[] = {0};
        sol(n, 1, n/2, a);
        System.out.println(a[0]);
    }

    private static void sol(int n, int l, int h, int [] a) {
        if(h < l) {
            return;
        }
        int mid = (l+h) / 2;
        int midSq = mid * mid;
        if(midSq <= n && Math.abs(n - a[0]) > Math.abs(n - mid)) {
             a[0] = mid;
        }
        if(midSq > n){
            sol(n, l, mid - 1, a);
        }
        else {
            sol(n, mid + 1, h, a);
        }
    }
}
