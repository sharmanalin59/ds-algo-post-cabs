package algo.revolut;

import java.util.List;
import java.util.Set;

/*
Register provider instances to the Load Balancer –
the max number of accepted providers from the load balancer is 10.
Each provider should have a unique address.
 */
public class LB {
    final Set<Server> servers;
    final int size = 10;

    public Set<Server> getServers() {
        return servers;
    }

    public LB(Set<Server> list) {
        if(list.size() > size) {
            throw new TooManyServerException("server count cant be more than "+size);
        }
        servers = list;
    }

    public void addServer(Server server) {
        if(servers.size() == size) {
            throw new TooManyServerException("server count cant be more than "+size);
        }
        if(servers.contains(server)) {
            throw new AddressAlreadyInuse("server address or name already in use ");
        }
        servers.add(server);
    }

    public void removeServer(Server server) {
        if(servers != null && servers.size() > 0 && !servers.contains(server)) {
            throw new ServerNotFound("server address not found ");
        }
        servers.remove(server);
    }
}
