package algo.revolut;

public class TooManyServerException extends RuntimeException{
    String mssg;
    TooManyServerException(String msg) {
        mssg = msg;
    }
}
