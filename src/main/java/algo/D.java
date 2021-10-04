package algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D {
    public static void main(String[] args) {
        /*Object i = 1;
        Double d = (Double)i;
        System.out.println(d);*/

        Object i =1.0;
        i = (Integer)i;
        System.out.println(i instanceof Double);
        System.out.println(i instanceof Integer);


            if(i instanceof Integer) {
                Integer u = (Integer) i;
                Double d = new Double(u);
                System.out.println(d);
            }
        Object c = 400;
        Map m = new HashMap();
        m.put("status",true);
        if(!Boolean.valueOf(m.get("status").toString())){
            System.out.println("man");
        }
    }
}
