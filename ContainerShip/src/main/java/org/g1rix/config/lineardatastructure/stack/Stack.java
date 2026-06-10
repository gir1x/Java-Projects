package org.g1rix.config.lineardatastructure.stack;

import org.g1rix.config.lineardatastructure.arraylist.ArrayList;

public class Stack<T> {

    private final ArrayList<T> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    public void push(T element) {
        stack.add(element);
    }

    public T pop() {

        if (isEmpty())
            throw new RuntimeException("Stack Underflow");

        return stack.remove(stack.size() - 1);
    }

    public T peek() {

        if (isEmpty())
            throw new RuntimeException("Stack is Empty");

        return stack.get(stack.size() - 1);
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void clear() {

        while (!isEmpty()) {
            pop();
        }
    }

    public void display() {

        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.println(stack.get(i));
        }
    }
}