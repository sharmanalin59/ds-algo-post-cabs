package hackerrank;

/**
 * @author nalin.sharma on 21/07/21
 */
public class P1 {
    /*
    #

  Given an integer n, return true if it is a power of ten. Otherwise, return false.
# An integer n is a power of ten, if there exists an integer x such that n == 10^x
# print(is_power_of_ten(1))  # true
# print(is_power_of_ten(10))  # true
# print(is_power_of_ten(1000))  # true
# print(is_power_of_ten(5))  # false
# print(is_power_of_ten(20))  # false
# print(is_power_of_ten(-1))  # false
# print(is_power_of_ten(0.00001))  # true
# print(is_power_of_ten(0.00002)) # false
     */
    public static void main(String[] args) {
        System.out.println(is_power_of_ten(10));
        double rem = (0.1)%10;
        System.out.println(rem);
    }

    private static boolean is_power_of_ten(double num) {
        Double tmp = num;
        int intVal = tmp.intValue();
        if(intVal == 0 && intVal < tmp + 1) {
            while(tmp < 1) {
                tmp *= 10.0;
            }
            if(tmp == 1.0)
            return true;
            return false;
        }
        if(tmp == intVal) {
            while(tmp != 0) {
                if(tmp % 10.0 != 0) {
                    return false;
                }
                tmp /= 10.0;
            }
            return true;
        }
        return false;
    }
}
