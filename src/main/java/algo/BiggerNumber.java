package algo;

import java.util.Arrays;

@FunctionalInterface
interface I {
    void hey();
}
public class BiggerNumber {
    public static void main(String[] args) {
        Integer a [] = {99,990};
        Arrays.sort(a, (a1,a2) -> {
            String s1 = "" + a1 + a2;
            String s2 = "" + a2 + a1;
            return s2.compareTo(s1);
        });
        Arrays.stream(a).forEach(System.out::println);
    }
}
