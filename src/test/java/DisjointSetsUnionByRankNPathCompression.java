import algo.revolut.TooManyServerException;
import graph.DisjointSetByUnionByRankNPathCompression;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author nalin.sharma on 15/06/21
 */
public class DisjointSetsUnionByRankNPathCompression {

    @Test
    public void test() {
        DisjointSetByUnionByRankNPathCompression.DSByUnion ds = new DisjointSetByUnionByRankNPathCompression.DSByUnion(10);
        ///set 1
        ds.union(1,2);
        Assert.assertEquals(1, ds.findRoot(2));
        Assert.assertEquals(1, ds.findRoot(1));
        ds.union(3,4);
        Assert.assertEquals(3, ds.findRoot(3));
        Assert.assertEquals(3, ds.findRoot(4));
        ds.union(1,4);
        Assert.assertEquals(1, ds.findRoot(1));
        Assert.assertEquals(1, ds.findRoot(2));
        Assert.assertEquals(1, ds.findRoot(3));
        Assert.assertEquals(1, ds.findRoot(4));

        ///set 2
        ds.union(5,6);
        ds.union(6,7);
        Assert.assertEquals(5, ds.findRoot(6));
        Assert.assertEquals(5, ds.findRoot(7));

        ///set 3
        ds.union(8,9);
        ds.union(9,10);
        Assert.assertEquals(8, ds.findRoot(9));
        Assert.assertEquals(8, ds.findRoot(10));

        //set 4
        ds.union(6,10);
        Assert.assertEquals(8, ds.getElement(9).parent.num);
        Assert.assertEquals(8, ds.getElement(10).parent.num);
        Assert.assertEquals(5, ds.findRoot(6));
        Assert.assertEquals(5, ds.findRoot(7));
        Assert.assertEquals(5, ds.findRoot(9));
        Assert.assertEquals(5, ds.findRoot(10));
        Assert.assertEquals(5, ds.getElement(9).parent.num);
        Assert.assertEquals(5, ds.getElement(10).parent.num);
    }

    @Test(expected = java.lang.RuntimeException.class)
    public void test_exception() {
        DisjointSetByUnionByRankNPathCompression.DSByUnion ds = new DisjointSetByUnionByRankNPathCompression.DSByUnion(7);
        ds.union(1,2);
        ds.union(3,4);
        ds.union(4,3);
        Assert.assertEquals(1, ds.findRoot(1));
        Assert.assertEquals(1, ds.findRoot(2));
        Assert.assertEquals(1, ds.findRoot(3));
        Assert.assertEquals(1, ds.findRoot(4));
    }
}
