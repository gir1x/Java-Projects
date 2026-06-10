package org.g1rix.config.lineardatastructure.linkedlist.singlylinkedlist;

import org.g1rix.config.lineardatastructure.CustomList;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedList<T> implements CustomList<T>, Iterable {

    private Node<T> head;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(T element) {

        Node<T> node = new Node<>(element);

        if (head == null) {
            head = node;
        } else {

            Node<T> temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = node;
        }

        size++;
        return true;
    }

    @Override
    public void add(int index, T element) {

        checkPosition(index);

        Node<T> node = new Node<>(element);

        if (index == 0) {
            node.next = head;
            head = node;
        } else {

            Node<T> prev = getNode(index - 1);

            node.next = prev.next;
            prev.next = node;
        }

        size++;
    }

    @Override
    public T get(int index) {

        checkElement(index);

        return getNode(index).data;
    }

    @Override
    public T set(int index, T element) {

        checkElement(index);

        Node<T> node = getNode(index);

        T old = node.data;
        node.data = element;

        return old;
    }

    @Override
    public T remove(int index) {

        checkElement(index);

        T removed;

        if (index == 0) {

            removed = head.data;
            head = head.next;

        } else {

            Node<T> prev = getNode(index - 1);

            removed = prev.next.data;
            prev.next = prev.next.next;
        }

        size--;

        return removed;
    }

    @Override
    public boolean remove(T element) {

        if (head == null) {
            return false;
        }

        if (Objects.equals(head.data, element)) {

            head = head.next;
            size--;
            return true;
        }

        Node<T> temp = head;

        while (temp.next != null) {

            if (Objects.equals(temp.next.data, element)) {

                temp.next = temp.next.next;
                size--;

                return true;
            }

            temp = temp.next;
        }

        return false;
    }

    @Override
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    @Override
    public int indexOf(T element) {

        Node<T> temp = head;
        int index = 0;

        while (temp != null) {

            if (Objects.equals(temp.data, element)) {
                return index;
            }

            temp = temp.next;
            index++;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(T element) {

        Node<T> temp = head;
        int index = 0;
        int result = -1;

        while (temp != null) {

            if (Objects.equals(temp.data, element)) {
                result = index;
            }

            temp = temp.next;
            index++;
        }

        return result;
    }

    @Override
    public void clear() {

        head = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {

                if (!hasNext())
                    throw new NoSuchElementException();

                T value = current.data;
                current = current.next;

                return value;
            }
        };
    }

    private Node<T> getNode(int index) {

        Node<T> temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    private void checkElement(int index) {

        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
    }

    private void checkPosition(int index) {

        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
    }
}