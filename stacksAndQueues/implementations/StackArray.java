package implementations;
import java.util.Iterator;
import java.util.NoSuchElementException;

import interfaces.Stack;

public class StackArray<Item> implements Stack<Item> {
    private Item[] stack = (Item[]) new Object[1];
    private int N = 0;

    @Override
    public void push(Item item) {
        if(N == stack.length) {
            resize(2 * stack.length);
        }

        stack[N++] = item;
    }

    @Override
    public Item pop() {
        if(N == 0) {
            throw new NoSuchElementException("cannot pop an empty stack");
        }

        Item item = stack[--N];
        stack[N] = null; // avoid loitering
        
        if(N > 0 && N == stack.length/4)  {
            resize(stack.length/2);
        }
        
        return item;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
       return N;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int arrayIndex = N;

        @Override
        public boolean hasNext() {
            return arrayIndex > 0;
        }

        @Override
        public Item next() {
            if(arrayIndex == 0) {
                throw new NoSuchElementException();
            }
            return stack[--arrayIndex];
        }
        
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        
        for(int i = 0; i < N; i++) {
            temp[i] = stack[i];
        }

        stack = temp;
    }
    
}
