public class InsertionSort extends Sort {

    @Override
    public void sort(Comparable[] array) {
        int N = array.length;
        for(int i = 1; i < N; i++) {
            for(int j = i; j > 0 && less(array[j], array[j-1]); j--) {
                exchange(array, j, j-1);
            }
        }
    }
}
