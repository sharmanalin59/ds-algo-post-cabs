package algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Nal {
    public static void main(String[] args) {
        List<String> products = new ArrayList<>();
        products.add("yellowShirt");
        products.add("yellowShirt");
        products.add("blackShirt");
        products.add("blackShirt");
        products.add("greenShirt");
        products.add("greenShirt");
        Map<String, Integer> fre = new HashMap<>();
        int max[] = {1};
        String out [] = {""};
        for(String product: products) {
            if(fre.containsKey(product)) {
                int newFre = fre.get(product) + 1;
                fre.put(product, newFre);
                if(newFre > max[0]) {
                    max[0] = newFre;
                }
            }
            else {
                fre.put(product, 1);
            }
        }
        System.out.println(out[0]);
        if(fre.size() > 0) {
            fre.forEach((k,v) -> {
                if(v == max[0] && (out[0].isEmpty() || out[0].compareTo(k) < 0)) {
                    out[0] = k;
                }
            });
        }
        System.out.println(out[0]+""+max[0]+fre.toString());
    }
}
