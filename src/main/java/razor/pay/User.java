package razor.pay;

/**
 * @author nalin.sharma on 19/06/21
 */
public class User {
    private long id;
    private String name;
    private String email;
    private String pass;

    public User(long id, String name, String email, String pass) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.pass = pass;
    }
}
