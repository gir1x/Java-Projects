package org.g1rix.config.lineardatastructure.queue;

import org.g1rix.config.lineardatastructure.arraylist.ArrayList;
import org.g1rix.config.lineardatastructure.linkedlist.singlylinkedlist.LinkedList;

public class Queue<T> {

    private final LinkedList<T> queue;

    public Queue() {
        queue = new LinkedList<T>();
    }

    public void offer(T element) {
        queue.add(element);
    }

    public T poll() {

        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow");
        }

        return queue.remove(0);
    }

    public T peek() {

        if (isEmpty()) {
            throw new RuntimeException("Queue is Empty");
        }

        return queue.get(0);
    }

    public int size() {
        return queue.size();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void clear() {
        queue.clear();
    }

    public void display() {

        for (Object element : queue) {
            System.out.print(element + " ");
        }

        System.out.println();
    }
}