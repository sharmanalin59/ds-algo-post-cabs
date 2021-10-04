package lending.kart;

/**
 * @author nalin.sharma on 27/09/21
 */
public class Vote {
    private Election election;
    private Candidate candidate;

    public Vote(Election election, Candidate candidate) {
        this.election = election;
        this.candidate = candidate;
    }

    public Election getElection() {
        return election;
    }

    public Candidate getCandidate() {
        return candidate;
    }
}
