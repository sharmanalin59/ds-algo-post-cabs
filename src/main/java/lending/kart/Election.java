package lending.kart;

import java.util.*;

/**
 * @author nalin.sharma on 27/09/21
 */
public class Election {
    private String name;
    private Map<String, List<Vote>> userVotes = new LinkedHashMap<>();
    private Map<Candidate, List<Vote>> votes = new LinkedHashMap<>();

    public String getName() {
        return name;
    }

    public Map<String, List<Vote>> getUserVotes() {
        return userVotes;
    }
}
