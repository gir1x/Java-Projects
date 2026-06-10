package org.g1rix.config.lineardatastructure.linkedlist.doublylinkedlist;

class DoublyNode<T> {

    T data;

    DoublyNode<T> next;
    DoublyNode<T> prev;

    DoublyNode(T data) {
        this.data = data;
    }
}