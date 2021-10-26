import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {

    static class Connection {
        Random r;
        int read() {
            return r.nextInt(10);
        }
        void close() {
            //close
        }
    }

    static class Pool {

        public Pool(int size) {
            this.size = size;
            conns = new LinkedBlockingQueue<>(size);
        }

        static class PoolConnection {
            public PoolConnection(Connection conn) {
                this.conn = conn;
            }
            void close() throws InterruptedException {
                conns.put(this);
            }
            int read() {
                return conn.read();
            }
            private Connection conn;
        }

        PoolConnection getConnection () throws InterruptedException {
            createCon();
            return conns.take();
        }

        private void createCon() throws InterruptedException {
            if(csize < size) {
                csize++;
                Connection c = new Connection();
                conns.put(new PoolConnection(c));
                usedConns.add(c);
            }
        }

        void shutdown() {
            usedConns.forEach(Connection::close);
        }

        static BlockingQueue<PoolConnection> conns;
        List<Connection> usedConns = new LinkedList<>();
        int size, csize = 0;
    }
}
