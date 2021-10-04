package algo.revolut;

import java.util.ArrayList;
import java.util.List;

public class C {
    static class CC {
        CC(boolean p){
            preferred = p;
        }
        boolean preferred;
        boolean getPreferred() {
            return preferred;
        }
    }
    public static void main(String[] args) {

        List<CC> ccs = new ArrayList<>();
        ccs.add(new CC(false));
        ccs.add(new CC(false));
        //ccs.add(new CC(true));
        boolean hasPreferredCC = ccs
                .stream()
                .anyMatch(CC::getPreferred);
        System.out.println(hasPreferredCC);

        try {
            throw new Exception("what man");
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
            //log.
        }
    }
}
