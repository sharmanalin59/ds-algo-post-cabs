import algo.revolut.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import java.util.HashSet;
import java.util.Set;

public class LBTest {

    static LB lb;
    static Set<Server> servers;
    static Server toBeRemovedA;

    @Before
    public void init() {
        servers = new HashSet<>();
        toBeRemovedA = new Server("A",8080);
        servers.add(toBeRemovedA);
        servers.add(new Server("B",8080));
        servers.add(new Server("C",8080));
        servers.add(new Server("D",8080));
        servers.add(new Server("E",8080));
        servers.add(new Server("F",8080));
        servers.add(new Server("G",8080));
        servers.add(new Server("H",8080));
        lb = new LB(servers);
    }

    @Test(expected = TooManyServerException.class)
    public void lbIntitialzedMoreThan10Servers_throw_exception() {
        Set<Server> servers = new HashSet<>();
        servers.add(new Server("A",8080));
        servers.add(new Server("B",8080));
        servers.add(new Server("C",8080));
        servers.add(new Server("D",8080));
        servers.add(new Server("E",8080));
        servers.add(new Server("F",8080));
        servers.add(new Server("G",8080));
        servers.add(new Server("H",8080));
        servers.add(new Server("I",8080));
        servers.add(new Server("J",8080));
        servers.add(new Server("K",8080));
        LB lb1 = new LB(servers);
    }
    @Test
    public void allowLbIntitialzedLessThan10Servers() {
        Set<Server> servers = new HashSet<>();
        servers.add(new Server("A",8080));
        servers.add(new Server("B",8080));
        servers.add(new Server("C",8080));
        servers.add(new Server("D",8080));
        servers.add(new Server("E",8080));
        servers.add(new Server("F",8080));
        servers.add(new Server("G",8080));
        servers.add(new Server("H",8080));
        servers.add(new Server("I",8080));
        servers.add(new Server("J",8080));
        LB lb1 = new LB(servers);
        Set<Server> serversGot = lb1.getServers();
        Assert.assertEquals(serversGot, servers);
    }

    //add
    @Test
    public void add_allowLessEqThan10Servers() {
        lb.addServer(new Server("I",8080));
        Assert.assertEquals(servers, lb.getServers());
    }

    @Test(expected = TooManyServerException.class)
    public void add_moreThan10Servers_throw_exception() {
        lb.addServer(new Server("I",8080));
        lb.addServer(new Server("J",8080));
        lb.addServer(new Server("K",8080));
    }

    @Test(expected = AddressAlreadyInuse.class)
    public void add_exisitingServer_throw_exception() {
        lb.addServer(new Server("A",8080));
    }

    //remove
    @Test(expected = ServerNotFound.class)
    public void remove_serverNotContained_throw_exception() {
        lb.removeServer(new Server("N",8080));
    }
    @Test
    public void remove_successfully() {
        lb.removeServer(toBeRemovedA);
        servers.remove(toBeRemovedA);
        Assert.assertEquals(servers, lb.getServers());
    }

    ErrorCollector e = new ErrorCollector();
    @Test
    public void e() {
        e.addError(new Throwable(""));
        //e.checkThat("hello", not(contains));

    }
}
