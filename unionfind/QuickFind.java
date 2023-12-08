/** An eager aproach to implementing the Union-Find
 */
public class QuickFind extends UF {

    public QuickFind(int N) {
        super(N);
    }

    @Override
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];

        if (pid == qid) return;

        // change all entries with id[p] to id[q]
        for(int i = 0; i < id.length; i++) {
            if(id[i] == pid) 
                id[i] = qid;
        }
        count--;
    }

    @Override
    public int find(int p) {
        return id[p];
    }    
}
