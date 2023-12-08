public class MergeSort extends Sort {
    private static Comparable[] aux;

    @Override
    public void sort(Comparable[] array) {
        aux = new Comparable[array.length];
        sort(array, aux, 0, array.length - 1);
        for(Comparable number : array) {
            System.out.println(number);
        }
    }

    private void sort(Comparable[] array, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(array, aux, lo, mid);
        sort(array, aux, mid+1, hi);
        merge(array, aux, lo, mid, hi);
    }

    private void merge(Comparable[] array, Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(array, lo, mid);
        assert isSorted(array, mid+1, hi);

        for(int k = lo; k <= hi; k++)
            aux[k] = array[k];
        
        int i = lo, j = mid+1;

        for(int k = lo; k <= hi; k++) {
            if      (i > mid)              array[k] = aux[j++]; // it verifies if array's left part is exhausted
            else if (j > hi)               array[k] = aux[i++]; // it verifies if array's right part is exhausted
            else if (less(aux[j], aux[i])) array[k] = aux[j++];
            else                           array[k] = aux[i++];
        }
        
        assert isSorted(array, lo, mid);
    }

    private boolean isSorted(Comparable[] array, int lo, int hi) { 
        // Test whether the array entries are in order.
        for (int i = lo; i < hi; i++)
            if (less(array[i], array[i-1])) return false;
        return true;
    }

    
}
