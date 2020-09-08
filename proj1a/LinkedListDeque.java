public class LinkedListDeque<T> {
    private class Node {
        private T val;
        private Node next;
        private Node prev;

        public Node(T v, Node p, Node n) {
            val = v;
            next = n;
            prev = p;
        }
    }

    private Node sentinel;
    private int size;
    private T dummy;

    public LinkedListDeque() {
        sentinel = new Node(dummy, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }
    /*
    public LinkedListDeque(T item) {
        sentinel = new Node(dummy, null, null);
        sentinel.next = new Node(item, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }
    */

    /* add to the front of the deque*/
    public void addFirst(T item) {
        sentinel.next = new Node(item, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    /* add to the end of the deque*/
    public void addLast(T item) {
        sentinel.prev = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    /* Return True if deque is empty, false otherwise*/
    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }

    /* Return number of items in the deque*/
    public int size() {
        return size;
    }

    public void printDeque() {
        Node n = sentinel.next;
        while (n != sentinel) {
            System.out.print(n.val);
            System.out.print(" ");
            n = n.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        T pop = sentinel.next.val;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return pop;
    }

    public T removeLast() {
        if (sentinel.next == sentinel) {
            return null;
        }
        T pop = sentinel.prev.val;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return pop;
    }

    public T get(int index) {
        if (sentinel.next == sentinel) {
            return null;
        }
        if (index >= size) {
            return null;
        }
        Node n = sentinel.next;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n.val;
    }

    private T getRecursivehelper(Node n, int index) {
        if (index == 0) {
            return n.val;
        }
        return getRecursivehelper(n.next, index - 1);
    }
    public T getRecursive(int index) {
        if (sentinel.next == sentinel) {
            return null;
        }
        if (index >= size) {
            return null;
        }
        return getRecursivehelper(sentinel.next, index);
    }
    /*
    public LinkedListDeque(LinkedListDeque other) {
        sentinel = new Node(dummy, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;

        for (int i = 0; i < other.size(); i += 1) {
            addLast((T) other.get(i));
        }
    }

     */
}
