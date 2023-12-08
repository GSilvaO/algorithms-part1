package interfaces;
/**
 * Also know as a FIFO(First in First Out) datatype, is a collection where
 * the least recently added object the first object to
 * "leave". A real life example would be a queue of people waiting to
 * be called in a hospital
 */
public interface Queue<T> extends Iterable<T> {
    /**
     * Add an item to the queue
     * @param t An object of any tyoe
     */
    void enqueue(T t);

    /**
     * Remove and return the least recently added item
     * @return The least recently added item
     */
    T dequeue();

    /**
     * Returns if the queue is empty
     * @return True if the queue is empty
     */
    boolean isEmpty();

    /**
     * Returns the number of items in the queue
     * @return The size of the queue collection
     */
    int size();
}
