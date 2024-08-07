/*
 * JOB INTERVIEW PROBLEM
 * Social network connectivity. Given a social network containing n 
 * members and a log file containing m timestamps at which times 
 * pairs of members formed friendships, design an algorithm to 
 * determine the earliest time at which all members are connected 
 * (i.e., every member is a friend of a friend of a friend ... of a friend). 
 * Assume that the log file is sorted by timestamp and that friendship is 
 * an equivalence relation. The running time of your algorithm should 
 * be m log n or better and use extra space proportional to n.
 * 
 */

 // refactor this algorithm to abstract the timestamp to an int that will be incremented
 // on each union command. The method returnEarliestTimestamp(which the name should be also
 // refactored) will return -1 in case of the count variable differs from 1
public class SocialNetwork {
    private WeightedQuickUnion weightedQuickUnion;
    private String m = "timestamp";

    public SocialNetwork(int n) {
        weightedQuickUnion = new WeightedQuickUnion(n);
    }

    public void makeFriendship(int p, int q) {
        weightedQuickUnion.union(p, q);
    }

    public String returnEarliestTimestamp() {
        if(weightedQuickUnion.count() == 1) 
            return m;
        
        return "";
    }
}
