public abstract class UF {

    protected int[] id;
    protected int count;

    /**
     * Initialize array with the numbers equal to its array index
     * @param N size of the object
     */
    public UF(int N) {
        count = N;
        id = new int[N];
        for(int i = 0; i < N; i++) {
            id[i] = i;
        }
    }
    
    /**
     * Checks if p and q are in the same component
     * @param p a number of type int to be checked if is connected with q
     * @param q a number of type int to be checked if is connected with p
     * @return a boolean indicating if p and q are connected
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    
    /**
     * Number of components
     * @return an int with the number of components
     */
    public int count() {
        return count;
    }
    
    /**
     * Component identifier for p(0 to N-1)
     * @param p 
     * @return component p
     */
    public abstract int find(int p);
    
    /**
     *  Add connection between p and q
     * @param p a number of type int to be connected with q
     * @param q a number of type int to be connected with p
     */
    public abstract void union(int p, int q);   
}