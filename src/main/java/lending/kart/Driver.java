package lending.kart;

/**
 * @author nalin.sharma on 27/09/21
 */
public class Driver {

    public static void main(String[] args) {
        ElectionApi electionApi = new ElectionApi();
        /*electionWinner.organiseElection("E1");
        electionWinner.voteVersionOne("Nalin", "C1", "E1");
        electionWinner.voteVersionOne("Rahul", "C1", "E1");
        electionWinner.voteVersionOne("Waseem", "C2", "E1");
        electionWinner.voteVersionOne("Moahn", "C3", "E1");*/

        //Candidate candidate = electionWinner.electionWinnerVersionOne("E1");
        //System.out.println("winner "+candidate.getName());

        electionApi.organiseElection("E1");
        electionApi.voteVersionTwo("Nalin", "C2", "E1");
        electionApi.voteVersionTwo("Nalin", "C2", "E1");
        electionApi.voteVersionTwo("Rahul", "C1", "E1");
       /* electionWinner.voteVersionTwo("Waseem", "C1", "E1");
        electionWinner.voteVersionTwo("Moahn", "C1", "E1");*/
        Candidate candidate = electionApi.electionWinnerVersionTwo("E1");
        System.out.println("winner "+candidate.getName());
    }
}
