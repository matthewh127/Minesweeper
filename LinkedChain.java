/**
 * Simple generic singly-linked chain used as a collection.
 * Provides add, remove, contains, size and get operations.
 */
public class LinkedChain<T> {
    private static class Node<E> {
        E element;
        Node<E> next;
        Node(E element) { this.element = element; }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    /** Adds an element to the end of the chain. O(1) */
    public void add(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        Node<T> node = new Node<>(element);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    /** Removes the first occurrence of the element. O(N) */
    public boolean remove(T element) {
        if (head == null) return false;
        if (head.element.equals(element)) {
            head = head.next;
            if (head == null) tail = null;
            size--;
            return true;
        }
        Node<T> prev = head;
        Node<T> curr = head.next;
        while (curr != null) {
            if (curr.element.equals(element)) {
                prev.next = curr.next;
                if (curr == tail) tail = prev;
                size--;
                return true;
            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    /** Returns true if the chain contains the element. O(N) */
    public boolean contains(T element) {
        Node<T> cur = head;
        while (cur != null) {
            if (cur.element.equals(element)) return true;
            cur = cur.next;
        }
        return false;
    }

    /** Returns the number of elements in the chain. O(1) */
    public int size() {
        return size;
    }

    /** Retrieves the element at the given index (0‑based). O(N) */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.element;
    }
}
