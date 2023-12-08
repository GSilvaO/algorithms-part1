package interfaces;
/**
 * Also know as a LIFO(Last in First Out) datatype. The most recently
 * added object is the last to "leave" as more objects are added to the
 * stack. It can be compared with a real life example of a stack of
 * dishes to be washed
 */
public interface Stack<T> extends Iterable<T> {
    /**
     * Add an item to the stack
     * @throws ArrayIndexOutOfBoundsException if the array has reached its
     * maximum capacity
     * @param t An object of any type
     */
    void push(T t);

    /**
     * Remove the most recently added item
     * @throws ArrayIndexOutOfBoundsException if the array has no elements
     * @return Most recently added item
     */
    T pop();

    /**
     * Checks if the stack is empty
     * @return True if the stack collection is empty
     */
    boolean isEmpty();

    /**
     * Number of items in the stack
     * @return Number of items
     */
    int size();

}
