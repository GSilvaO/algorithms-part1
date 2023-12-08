public class SortTest {
    public static void main(String[] args) {
        Sort mergeSort = new MergeSort();
        Integer[] array = {3, 4, 7, 1, 5, 8, 2, 6};
        mergeSort.sort(array);
    }
}