import algo.LL;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LLReverseTest {
    static LL<Integer> ll = new LL<>();
    @BeforeClass
    public static void m1() {
        ll.addEnd(1);
    }

    @Test
    public void Ll() {
        LL<Integer> ll1 = new LL<>();
        ll1.addEnd(1);
        ll1.addEnd(2);
        ll1.addEnd(3);
        ll1.addEnd(4);
        ll1.rev(2);
        Integer arr[] = {2,1,4,3};

        Assert.assertEquals(arr,ll1.arr());

        List l1 = new ArrayList();
        l1.add(1);


        List l2 = new ArrayList();
        l2.add(1);
        Assert.assertEquals(l1,l2);
    }
}
