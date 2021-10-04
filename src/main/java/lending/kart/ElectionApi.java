package lending.kart;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author nalin.sharma on 27/09/21
 */
public class ElectionApi {

    Map<String, Election> electionMap = new HashMap<>();

    void organiseElection(String electionName) {
        if(electionMap.containsKey(electionName)) {
            throw new RuntimeException("Election already exists");
        }
        electionMap.put(electionName, new Election());
    }

    void voteVersionOne(String user, String candidateName, String electionName) {
        if(!electionMap.containsKey(electionName)) {
            throw new RuntimeException("Election doesnt exist");
        }
        Map<String, List<Vote>> userVotes = electionMap.get(electionName).getUserVotes();
       if(userVotes.containsKey(user)) {
           throw new RuntimeException("User vote exists");
       }
       List<Vote> votes = new ArrayList<>();
       votes.add(new Vote(electionMap.get(electionName), new Candidate(candidateName)));
       userVotes.put(user, votes);
    }

    Candidate electionWinnerVersionOne(String electionName) {
        if(!electionMap.containsKey(electionName)) {
            throw new RuntimeException("Election doesnt exist");
        }
        Map<String, List<Vote>> userVotes = electionMap.get(electionName).getUserVotes();
        Map<Candidate, Long> candidateVotes = userVotes
                .values()
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.groupingBy(Vote::getCandidate, Collectors.counting()));


        Candidate [] winner = new Candidate[1];
        Long maxCnt [] = new Long[1];
        maxCnt[0] = 0l;
        candidateVotes.forEach((k,v) -> {
            if(v > maxCnt[0]) {
                maxCnt[0] = v;
                winner[0] = k;
            }
        });
        return winner[0];
    }

    Candidate electionWinnerVersionTwo(String electionName) {
        if(!electionMap.containsKey(electionName)) {
            throw new RuntimeException("Election doesnt exist");
        }
        Map<String, List<Vote>> userVotes = electionMap.get(electionName).getUserVotes();

        Map<Candidate, Long> candidateVotes = new HashMap<>();

        userVotes.forEach((k,v)-> {
            if(v != null && v.size() > 0) {
                for (int i = 0; i < v.size(); i++) {
                    Candidate candidate = v.get(i).getCandidate();
                    if (!candidateVotes.containsKey(v.get(i).getCandidate())) {
                        candidateVotes.put(candidate, 0l);
                    }
                    if(i == 0) {
                        candidateVotes.put(candidate, candidateVotes.get(candidate) + 3l);
                    }
                    else if( i == 1) {
                        candidateVotes.put(candidate, candidateVotes.get(candidate) + 2l);
                    }
                    else if (i == 2) {
                        candidateVotes.put(candidate, candidateVotes.get(candidate) + 1l);
                    }
                }
            }

        });

        Candidate [] winner = new Candidate[1];
        Long maxCnt [] = new Long[1];
        maxCnt[0] = 0l;
        candidateVotes.forEach((k,v) -> {
            if(v > maxCnt[0]) {
                maxCnt[0] = v;
                winner[0] = k;
            }
        });
        return winner[0];
    }

    void voteVersionTwo(String user, String candidateName, String electionName) {
        if(!electionMap.containsKey(electionName)) {
            throw new RuntimeException("Election doesnt exist");
        }
        Map<String, List<Vote>> userVotes = electionMap.get(electionName).getUserVotes();
        if(!userVotes.containsKey(user)) {
            userVotes.put(user, new ArrayList<>());
        }
        if( userVotes.get(user).size() == 3) {
            throw new RuntimeException("User cant vote");
        }
        userVotes.get(user).add(new Vote(electionMap.get(electionName), new Candidate(candidateName)));
    }

}
