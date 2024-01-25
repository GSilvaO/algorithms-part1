public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] priorityQueue;
    private int N = 0;

    public MaxPQ(int maxN) {
        priorityQueue = (Key[]) new Comparable[maxN+1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        priorityQueue[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = priorityQueue[1];
        exchange(1, N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }

    private void swim(int k) {
        while(k > 1 && less(k/2, k)) {
            exchange(k/2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while(2*k <= N) {
            int j = 2*k;
            if(j < N && less(j, j+1)) j++;
            if(!less(k, j)) break;
            exchange(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return priorityQueue[i].compareTo(priorityQueue[j]) < 0;
    }

    private void exchange(int i, int j) {
        Key t = priorityQueue[i];
        priorityQueue[i] = priorityQueue[j];
        priorityQueue[j] = t;
    }
}