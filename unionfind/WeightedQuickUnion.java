/**
 * This algorithm keep track of trees' size to
 * keep then as flat as possible
 */
public class WeightedQuickUnion extends UF{
    private int[] sz; // size of component for roots

    public WeightedQuickUnion(int N) {
        super(N);
        
        sz = new int[N];
        for(int i = 0; i < N; i++)
            sz[i] = 1;
    }

    /**
     * Chase parent pointers until reach root
     * @param i is an int that will be p or q's root
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

        if(sz[pRoot] < sz[qRoot]) {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
        else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }

        count--;
    }

    @Override
    public int find(int p) {
        return root(p);
    }
}
