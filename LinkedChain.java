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
    /**
 * Prints the chain interpreted as a Minesweeper board using the supplied Board
 * to determine dimensions and to compute adjacent mine counts.
 *
 * For Tile elements:
 *  - hidden & flagged => [F]
 *  - hidden & not flagged => [ ]
 *  - revealed mine => [*]
 *  - revealed non-mine => [n] (blank for 0)
 *
 * For non-Tile elements the element's toString() is printed inside brackets.
 *
 * @param board the Board instance (must not be null)
 * @throws IllegalArgumentException if board is null
 */
public void printBoard(Board board) {
    if (board == null) throw new IllegalArgumentException("board cannot be null");

    int rows = board.getRows();
    int cols = board.getCols();

    Node<T> cur = head;
    for (int r = 0; r < rows; r++) {
        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < cols; c++) {
            if (c > 0) sb.append(' ');
            if (cur == null) {
                sb.append("[ ]");
                continue;
            }

            if (cur.element instanceof Tile) {
                Tile t = (Tile) cur.element;
                if (!t.isRevealed()) {
                    sb.append(t.isFlagged() ? "[F]" : "[ ]");
                } else {
                    if (t.isMine()) {
                        sb.append("[*]");
                    } else {
                        int adj = t.getAdjacentMines(board, r, c);
                        sb.append("[").append(adj == 0 ? " " : Integer.toString(adj)).append("]");
                    }
                }
            } else {
                Object el = cur.element;
                sb.append("[").append(el == null ? " " : el.toString()).append("]");
            }

            cur = cur.next;
        }
        System.out.println(sb.toString());
    }
}
    
}
