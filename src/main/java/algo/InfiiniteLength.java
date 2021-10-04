package algo;

/**
 * @author nalin.sharma on 17/08/21
 * https://www.geeksforgeeks.org/minimum-steps-to-reach-a-destination/
 *
 *   2   4     6       8              10                12                   14                      16                         18                            20                               22
 * 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72
 *   ^   ^     ^       ^              ^                 ^                    ^                       ^                           ^                            ^                                ^
 */
public class InfiiniteLength {
    public static void main(String[] args) {
        int at = 0;
        int item = 7, steps = 0, cnt = 2;
        while(item > at) {
            steps++;
            at += steps;
            if(at == item) {
                System.out.println("min steps required. "+ steps);
                return;
            }
        }
        while(cnt >= 0) {
            if((at - item) % 2 == 0) {
                System.out.println("min steps required "+ steps);
                return;
            }
            steps++;
            at += steps;
            cnt--;
        }
        System.out.println("not possible");
    }
}
