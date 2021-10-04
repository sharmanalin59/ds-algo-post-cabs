package razor.pay;

/**
 * @author nalin.sharma on 19/06/21
 */
public class DocumentCreationException extends RuntimeException {
    DocumentCreationException(String m) {
        message = m;
    }
    String message;
}
