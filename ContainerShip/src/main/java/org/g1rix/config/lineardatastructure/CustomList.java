package org.g1rix.config.lineardatastructure;


public interface CustomList<T>  {

    int size();

    boolean isEmpty();

    boolean contains(T element);

    boolean add(T element);

    void add(int index, T element);

    T get(int index);

    T set(int index, T element);

    T remove(int index);

    boolean remove(T element);

    void clear();

    int indexOf(T element);

    int lastIndexOf(T element);


}