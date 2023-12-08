import edu.princeton.cs.algs4.StdRandom;

public class QuickSort extends Sort {

    @Override
    public void sort(Comparable[] array) {
        StdRandom.shuffle(array);
        sort(array, 0, array.length - 1);
    }

    private void sort(Comparable array[], int lo, int hi) {
        if(hi <= lo) return;
        int j = partitition(array, lo, hi);
        sort(array, lo, j - 1);
        sort(array, j + 1, hi);
    }

    private int partitition(Comparable[] array, int lo, int hi) {
        int i = lo, j = hi + 1;

        while(true) {
            // find item on left to swap
            while(less(array[++i], array[lo])) 
                if(i == hi) break;

            // find item on right to swap
            while(less(array[lo], array[--j]))
                if(j == lo) break;
            
            //check if pointers cross
            if(i >= j) break;
            exchange(array, i, j);
        }

        exchange(array, lo, j);
        return j;
    }
}
