/*
 * JOB INTERVIEW PROBLEM
 * Union-find with specific canonical element. Add a method find() to the 
 * union-find data type so that find(i) returns the largest element in 
 * the connected component containing i. The operations, union(), connected(), 
 * and find() should all take logarithmic time or better.
 * For example, if one of the connected components is {1, 2, 6, 9}, then 
 * the find() method should return 9 for each of the four elements in the 
 * connected components 
 */


// refactor this class to extend from UF

public class UFCanonicalElement {
    private int id[];
    private int count;
    private int[] sz; // size of component for roots
    private int[] componentsGreaterNumber;

    public UFCanonicalElement(int N) {
        count = N;

        id = new int[N];
        componentsGreaterNumber = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
            componentsGreaterNumber[i] = i;
        }
        
        sz = new int[N];
        for(int i = 0; i < N; i++)
            sz[i] = 1;
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

        if(componentsGreaterNumber[pRoot] > componentsGreaterNumber[qRoot]) {
            componentsGreaterNumber[qRoot] = componentsGreaterNumber[pRoot];
        }
        else if(componentsGreaterNumber[qRoot] > componentsGreaterNumber[pRoot]) {
            componentsGreaterNumber[pRoot] = componentsGreaterNumber[qRoot];
        }

        count--;
    }

    public int find(int i) {
        return componentsGreaterNumber[root(i)];
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}