package implementations;

import java.util.Iterator;
import java.util.NoSuchElementException;

import interfaces.Queue;

public class QueueLinkedList<Item> implements Queue<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item content;
        Node next;
    }

    @Override
    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.content = item;
        last.next = null;
        
        if(isEmpty()) {
            first = last;
        }
        else {
            oldlast.next = last;
        }

        N++;
    }

    @Override
    public Item dequeue() {
        if(isEmpty()) {
            throw new NoSuchElementException();
        }
        
        Item item = first.content;
        first = first.next;
        if(first == null) {
            last = null;
        }
        N--;

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
        return new QueueLinkedListIterator();
    }

    private class QueueLinkedListIterator implements Iterator<Item>{
        Node currentNode = first;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Item next() {
            Item item = currentNode.content;
            currentNode = currentNode.next;
            return item;
        }

    }
}
