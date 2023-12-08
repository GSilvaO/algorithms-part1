/** lazy approach to union-find problem
*/ 
public class QuickUnion extends UF {

    public QuickUnion(int N) {
        super(N);
    }

    /**
     * Chase parent pointers until reach root
     * @param i is an in that will be p or q's root
     * @return the root of p or q
     */
    private int root(int i) {
        while(i != id[i])
            i = id[i];
        return i;
    }

    /**
     * Change root of p to point to root of q
     * @param p is an int
     * @param q is an int
     */
    @Override
    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);

        if(pRoot == qRoot) return;

        id[pRoot] = qRoot;

        count--;
    }

    @Override
    public int find(int p) {
        return root(p);
    }
}
