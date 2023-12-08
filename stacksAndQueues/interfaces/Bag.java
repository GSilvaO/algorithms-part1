package interfaces;
/**
 * A bag is a collection where removing items is not supported. Its
 * purpose is to provide clients with the ability to collect items and
 * then to iterate through the collected items
 */
public interface Bag<T> extends Iterable<T> {
    /**
     * Add an item to the bag
     * @param t An object of any type
     */
    void add(T t);

    /**
     * Returns if the bag is empty
     * @return True if the bag collection is empty
     */
    boolean isEmpty();

    /**
     * The number of items in the bag
     * @return The size of the bag collection
     */
    int size();
}