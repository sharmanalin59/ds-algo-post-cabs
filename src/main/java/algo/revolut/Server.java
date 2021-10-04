package algo.revolut;

import java.util.Objects;

public class Server {
    final private String ip;
    final private int port;

    public Server(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Server server = (Server) o;
        return ip.equalsIgnoreCase(server.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip);
    }
}
