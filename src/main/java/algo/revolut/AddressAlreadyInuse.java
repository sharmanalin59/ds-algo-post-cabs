package algo.revolut;

public class AddressAlreadyInuse extends RuntimeException{
    String mssg;
    AddressAlreadyInuse(String msg) {
        mssg = msg;
    }
}
