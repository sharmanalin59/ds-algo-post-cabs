import algo.BST;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class BSTTest {
    static BST.Node start = null;

    @BeforeClass
    public static void m1() {
        start = BST.add(start, 5);
        start = BST.add(start, 4);
        start = BST.add(start, 6);
    }

    @Test
    public void myFirstMethod() {
        // assertEquals("JUnit is working fine",str);
        int d[] = {0};

        BST.Node node = BST.lca1(start, 8, 9, d);
        Assert.assertEquals(null, node);
        Assert.assertEquals(0, d[0]);
    }

    @Test
    public void myFirstMethod1() {
        // assertEquals("JUnit is working fine",str);
        int d[] = {0};

        BST.Node node = BST.lca1(start, 6, 4, d);
        Assert.assertEquals(5, node.getC());
        Assert.assertEquals(2, d[0]);
    }

    @Test
    public void myFirstMethod2() {
        // assertEquals("JUnit is working fine",str);
        int d[] = {0};

        BST.Node node = BST.lca1(start, 5, 8, d);
        Assert.assertEquals(5, node.getC());
        Assert.assertEquals(1, d[0]);
        Assert.assertFalse(BST.exists(node, 8));
    }

    @Test
    public void myFirstMethod3() {
        // assertEquals("JUnit is working fine",str);
        int d[] = {0};

        BST.Node node = BST.lca1(start, 5, 6, d);
        Assert.assertEquals(5, node.getC());
        Assert.assertEquals(1, d[0]);
        Assert.assertTrue(BST.exists(node, 6));

    }
}
