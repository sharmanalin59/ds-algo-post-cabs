package algo.sixt;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class First {


    private static void rec(int ind, int num, Set<Integer> temp, List<Set<Integer>> out) {
        if(ind == num) {
            out.add(temp);
            return;
        }

        for(int cur = 1; cur <= num; cur++) {

            boolean cond1 = cur%(temp.size() + 1) == 0;
            boolean cond2 = (temp.size() + 1)%cur == 0;
            boolean cond3 = cond1 || cond2;

            if(cur <= num && cond3 && !temp.contains(cur)) {
                Set<Integer> newTemp = new LinkedHashSet<>(temp);
                newTemp.add(cur);
                rec(ind+1,num,newTemp,out);
            }
        }
    }

    public static int arrangements(int n) {
        // Write your code here
        List<Set<Integer>> out = new ArrayList<>();
        Set<Integer> temp = new LinkedHashSet<>();
        rec(0,n,temp,out);
        return out.size();
    }

    public static void dfs(int i, int j, int[] stepss, int badIndex, int max[]) {
        if(stepss[0] >= 0) {
            if(max[0] < i) {
                max[0] = i;
            }
            boolean cond = (i+j == badIndex);
            stepss[0]--;
            if(cond){
                dfs(i,j+1,stepss,badIndex,max);
            }
            else{
                dfs(i+j,j+1,stepss,badIndex,max);
            }
        }
    }
    public static int maxIndex(int steps, int badIndex) {
        // Write your code here

        int max[] = {0};
        int stepss [] = new int[1];
        stepss[0] =  steps;
        int i = 0, j = 1;
        dfs(i,j,stepss,badIndex, max);
        return max[0];
    }
    public static void main(String[] args) {

        //System.out.println(arrangements(2));
        //System.out.println(maxIndex(3,3));
        int N = -1;
        System.out.println(Integer.toString(N));

        String sN = Integer.toString(N);
        int i;
        if(N >= 0) {
            for( i = 0; i < sN.length(); i++) {
                if(sN.charAt(i) < '5') {
                    break;
                }
            }
            sN = sN.substring(0,i) + '5' + sN.substring(i) + ".";
        }
        else {

            for( i = 1; i < sN.length(); i++) {
                if(sN.charAt(i) > '5') {
                    break;
                }
            }
            sN = sN.substring(0,i) + '5' + sN.substring(i) + ".";
        }
        System.out.println(sN);




        List<SoldProduct> products = new ArrayList<>();
        products.add(new SoldProduct("nalin",1));
        products.add(new SoldProduct("nipun",2));
        products.add(new SoldProduct("nipun",20));
        Map<String,Integer> productSumMap = products.stream().collect(Collectors.groupingBy((product) -> product.name,
                Collectors.summingInt(product->product.price)));
        //System.out.println(c);

        Collection<SoldProduct> priceList = products.stream().collect(Collectors.toMap(p -> p.name, p -> p, (p, q) -> p)).values();

        Integer productRevenue = products.stream().map(product -> product.price).reduce(0, Integer::sum);;

        Stream<Integer> se = Stream.<Integer>empty();
        Stream<String> emptyStr = Stream.of();
        /*Optional<Integer> s;
        s.isPresent();
        s.get()*/
        System.out.println(productRevenue);
        for(SoldProduct price: priceList) {
            System.out.println(price.price);
        }
    }


        /*products.stream().map(product -> {
            new SoldProductsAggregate();
        }).collect(Collectors.toList());*/


    static class SoldProduct{
        SoldProduct(String p, int i) {
            name = p;
            price = i;
        }
        String name;
        int price;
        String currency;
    }
    class SimpleSoldProduct {
        String name;
        int price;
    }
    static class SoldProductsAggregate{
        List<SimpleSoldProduct> products;
        int total;
    }
}
