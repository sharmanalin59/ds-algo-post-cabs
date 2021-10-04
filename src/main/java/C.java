/*
import com.google.common.base.Strings;

import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class C {

    private static final Double FIRSTLIMIT = 10000000d;
    private static final Double SECONDLIMIT = 100000d;
    private static final Double THIRDLIMIT = 10000d;
    private static final String DEFAULT_DECIMAL_FORMAT = "##,##,##,##,##,##,##0";
    private static final String DECIMAL_FORMAT_WITH_SUFFIX = "##,##,##,##,##,##,##0.00";

    public static String formatValue(double value, String currency_label) {

        String suffix = null;
        if(currency_label == null || currency_label.isEmpty()) {
            currency_label = "";
        }
        DecimalFormat df = new DecimalFormat(currency_label + " " + DEFAULT_DECIMAL_FORMAT);
        value = Math.floor(value);
        if (value >= FIRSTLIMIT.doubleValue()) {
            value = (value / FIRSTLIMIT.doubleValue());
            suffix = "Cr";
        } else if (value >= SECONDLIMIT.doubleValue() && value < FIRSTLIMIT.doubleValue()) {
            value = (value / SECONDLIMIT.doubleValue());
            suffix = "Lac";
        } else if (value >= THIRDLIMIT) {
            value = (value / 1000d);
            suffix = "K";
        }
        if (!Strings.isNullOrEmpty(suffix)) {
            df = new DecimalFormat(currency_label + " " + DECIMAL_FORMAT_WITH_SUFFIX);
        }
        return (df.format(value) + " " + (suffix != null ? suffix : ""));
    }

    public static void main(String[] args) {
        double d = 0.900901;
        System.out.println(formatValue(10022.0022,"INR")+"   "+new DecimalFormat("#0.000").format(1222223.33232));


        byte[] bytes = new byte[10];

        String str = new String(bytes, Charset.forName("UTF-8"));

        String inr = "\u20B9";
        String euro = "\u20AC";
        System.out.println(inr);
        System.out.println(String.format(" \u20AC", 123));

        Object c = new ArrayList<>();
        //Object d = "";
        System.out.println(c instanceof List);
        System.out.println(c.getClass() == ArrayList.class);
        //System.out.println(d instanceof String);
    }
}
*/
