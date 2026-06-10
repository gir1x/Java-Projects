package org.g1rix.config.lineardatastructure.arraylist;

import org.g1rix.config.lineardatastructure.CustomList;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ArrayList<T> implements CustomList<T> {

    private static final int INITIAL_CAPACITY = 16;

    private T[] arr;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public ArrayList() {
        this.capacity = INITIAL_CAPACITY;
        this.arr = (T[]) new Object[capacity];
        this.size = 0;
    }

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

        if (size == capacity) {
            grow();
        }

        arr[size++] = element;
        return true;
    }

    @Override
    public void add(int index, T element) {

        checkPositionIndex(index);

        if (size == capacity) {
            grow();
        }

        for (int i = size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }

        arr[index] = element;
        size++;
    }

    @Override
    public T get(int index) {
        checkElementIndex(index);
        return arr[index];
    }

    @Override
    public T set(int index, T element) {

        checkElementIndex(index);

        T oldValue = arr[index];
        arr[index] = element;

        return oldValue;
    }

    @Override
    public T remove(int index) {

        checkElementIndex(index);

        T removed = arr[index];

        for (int i = index + 1; i < size; i++) {
            arr[i - 1] = arr[i];
        }

        arr[--size] = null;

        if (capacity > INITIAL_CAPACITY && size < capacity / 4) {
            shrink();
        }

        return removed;
    }

    @Override
    public boolean remove(T element) {

        int index = indexOf(element);

        if (index == -1) {
            return false;
        }

        remove(index);
        return true;
    }

    @Override
    public void clear() {

        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }

        size = 0;
    }

    @Override
    public int indexOf(T element) {

        for (int i = 0; i < size; i++) {

            if (Objects.equals(arr[i], element)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(T element) {

        for (int i = size - 1; i >= 0; i--) {

            if (Objects.equals(arr[i], element)) {
                return i;
            }
        }

        return -1;
    }

    private void grow() {

        capacity *= 2;

        @SuppressWarnings("unchecked")
        T[] newArray = (T[]) new Object[capacity];

        System.arraycopy(arr, 0, newArray, 0, size);

        arr = newArray;
    }

    private void shrink() {

        capacity /= 2;

        @SuppressWarnings("unchecked")
        T[] newArray = (T[]) new Object[capacity];

        System.arraycopy(arr, 0, newArray, 0, size);

        arr = newArray;
    }

    private void checkElementIndex(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size);
        }
    }

    private void checkPositionIndex(int index) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size);
        }
    }

    public void display() {

        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}