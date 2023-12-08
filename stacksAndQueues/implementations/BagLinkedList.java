package implementations;

import java.util.Iterator;

import interfaces.Bag;

public class BagLinkedList<Item> implements Bag<Item> {
    private Node first;
    private int N;

    private class Node {
        Item content;
        Node next;
    }

    @Override
    public void add(Item item) {
        Node node = new Node();
        node.content = item;
        node.next = first;
        first = node;
        N++;
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
        return new BagIterator();
    }

    private class BagIterator implements Iterator<Item>{
        private Node currentNode = first;

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
