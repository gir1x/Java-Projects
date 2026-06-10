package org.g1rix.config.lineardatastructure.linkedlist.doublylinkedlist;

import org.g1rix.config.lineardatastructure.CustomList;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class DoublyLinkedList<T> implements CustomList<T>, Iterable<T> {
    private DoublyNode<T> head;
    private DoublyNode<T> tail;
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
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }

    @Override
    public boolean add(T element) {

        DoublyNode<T> node = new DoublyNode<>(element);

        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        size++;
        return true;
    }

    @Override
    public void add(int index, T element) {

        checkPosition(index);

        if (index == size) {
            add(element);
            return;
        }

        DoublyNode<T> current = getNode(index);
        DoublyNode<T> node = new DoublyNode<>(element);

        node.next = current;
        node.prev = current.prev;

        if (current.prev != null) {
            current.prev.next = node;
        } else {
            head = node;
        }

        current.prev = node;

        size++;
    }

    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    @Override
    public T set(int index, T element) {

        DoublyNode<T> current = getNode(index);

        T old = current.data;
        current.data = element;

        return old;
    }

    @Override
    public T remove(int index) {

        DoublyNode<T> current = getNode(index);

        if (current.prev != null)
            current.prev.next = current.next;
        else
            head = current.next;

        if (current.next != null)
            current.next.prev = current.prev;
        else
            tail = current.prev;

        size--;

        return current.data;
    }

    @Override
    public boolean remove(T element) {

        DoublyNode<T> current = head;

        while (current != null) {

            if (Objects.equals(current.data, element)) {

                if (current.prev != null)
                    current.prev.next = current.next;
                else
                    head = current.next;

                if (current.next != null)
                    current.next.prev = current.prev;
                else
                    tail = current.prev;

                size--;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int indexOf(T element) {

        DoublyNode<T> current = head;
        int index = 0;

        while (current != null) {

            if (Objects.equals(current.data, element))
                return index;

            current = current.next;
            index++;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(T element) {

        DoublyNode<T> current = tail;
        int index = size - 1;

        while (current != null) {

            if (Objects.equals(current.data, element))
                return index;

            current = current.prev;
            index--;
        }

        return -1;
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            private DoublyNode<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {

                if (!hasNext())
                    throw new NoSuchElementException();

                T data = current.data;
                current = current.next;

                return data;
            }
        };
    }

    private DoublyNode<T> getNode(int index) {

        checkIndex(index);

        if (index < size / 2) {

            DoublyNode<T> current = head;

            for (int i = 0; i < index; i++)
                current = current.next;

            return current;

        } else {

            DoublyNode<T> current = tail;

            for (int i = size - 1; i > index; i--)
                current = current.prev;

            return current;
        }
    }

    private void checkIndex(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size);
        }
    }

    private void checkPosition(int index) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size);
        }
    }

    public void display() {

        DoublyNode<T> current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }
}