package implementations;

import java.util.Iterator;
import java.util.NoSuchElementException;

import interfaces.Stack;

public class StackLinkedList<Item> implements Stack<Item> {
    private Node stacksTop;
    private int N;

    private class Node {
        Item content;
        Node next;
    }
    
    @Override
    public void push(Item item) {
        Node node = new Node();
        node.content = item;
        node.next = stacksTop;
        stacksTop = node;
        N++;
    }

    @Override
    public Item pop() {
        if(N == 0) {
            throw new NoSuchElementException();
        }
        Item item = stacksTop.content;
        stacksTop = stacksTop.next;
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
        return new LinkedListStackIterator();
    }

    private class LinkedListStackIterator implements Iterator<Item> {
        private Node currentNode = stacksTop;

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
