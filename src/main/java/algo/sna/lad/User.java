package algo.sna.lad;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    User(String n) {
        name = n;
    }
    String name;
    int at;
    static final List<User> users = new ArrayList<>();

    static User subscribe(String user, Grid grid) {
        User u = new User(user);
        users.add(u);
        //grid.addUsers(u, 1);
        return u;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
