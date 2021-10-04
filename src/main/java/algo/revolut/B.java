package algo.revolut;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class B {
    public static void main(String[] args) {
        Boolean c = true;
        System.out.println(Boolean.parseBoolean(c.toString()));
        Object b = 1;
        double s = (Integer)b;
        Map<String,Object> attributes = new HashMap<>();
        Map<String,Object> preWaitTimeChargeInfo = new HashMap<>();
        preWaitTimeChargeInfo.put("pre_wait_time_charge", "2");

                  Object preWaitTimeCharge = preWaitTimeChargeInfo.get("pre_wait_time_charge");
                    if (Objects.nonNull(preWaitTimeCharge) && preWaitTimeCharge instanceof Integer) {
                        attributes.put("waiting_fee", ((Integer) preWaitTimeCharge).doubleValue());
                        }
                    else if (Objects.nonNull(preWaitTimeCharge) && preWaitTimeCharge instanceof Double) {
                            attributes.put("waiting_fee", (Double) preWaitTimeCharge);
                        }
                    else if (Objects.nonNull(preWaitTimeCharge) && preWaitTimeCharge instanceof String) {
                        attributes.put("waiting_fee", Double.valueOf((String) preWaitTimeCharge));
                    }
                    else {
                            attributes.put("waiting_fee", 0.0);
                        }
        System.out.println(attributes.get("waiting_fee") +" "+ (attributes.get("waiting_fee") instanceof Double));

        System.out.println(Double.valueOf((String) "2.0"));
    }
}
