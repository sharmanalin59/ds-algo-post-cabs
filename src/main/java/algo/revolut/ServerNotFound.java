package algo.revolut;

public class ServerNotFound extends RuntimeException{
    String mssg;
    ServerNotFound(String msg) {
        mssg = msg;
    }
}
