public class HeapSort extends Sort {

    @Override
    public void sort(Comparable[] array) {
        int N = array.length;

        for(int k = N / 2; k >= 1; k--) {
            sink(array, k, N);
        }

        while(N > 1) {
            exchange(array, 1, N);
            sink(array, 1, N--);
        }
    }

    private void sink(Comparable[] array, int k, int N) {
        while(2 * k <= N) {
            int j = 2 * k;
            if(j < N && less(j, j + 1)) j++;
            if(!less(k, j)) break;
            exchange(array, k, j);
            k = j;
        }
    }

    private boolean less(Comparable[] array, int i, int j) {
        /* decrementing 1 because heap data structure starts at 1 
        * and we want to work with the index 0
        */ 
        i -= 1;
        j -= 1;
        return array[i].compareTo(array[j]) < 0;
    }

    @Override
    protected void exchange(Comparable[] array, int i, int j) {
        i -= 1;
        j -= 1;
        Comparable swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }

}