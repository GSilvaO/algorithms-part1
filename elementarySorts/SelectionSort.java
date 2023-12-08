public class SelectionSort extends Sort {

    @Override
    public void sort(Comparable[] array) {
        int N = array.length;

        for(int i = 0; i < N; i++) {
            int minIndex = i;
            for(int j = i + 1; j < N; j++) {
                if(less(array[j], array[minIndex]))
                    minIndex = j;
            exchange(array, i, minIndex);
            }
        } 
    } 
}
