public abstract class Sort {

    public abstract void sort(Comparable[] array);

    protected boolean less(Comparable x, Comparable y) {
        return x.compareTo(y) < 0;
    }

    protected void exchange(Comparable[] array, int i, int j) {
        Comparable swap = array[i];
        array[i] = array[j];
        array[j] = swap;
    }
}