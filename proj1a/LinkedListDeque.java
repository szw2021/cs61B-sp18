public class LinkedListDeque<T> {

    private class Node {
        private T item;
        private Node prev;
        private Node next;

        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;
    private Node last;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        last = new Node(null, null, null);
        sentinel.next = last;
        sentinel.prev = last;
        last.prev = sentinel;
        last.next = sentinel;
        size = 0;
    }


    public void addFirst(T item) {
        size++;
        Node p = sentinel.next;
        Node newNode = new Node(item, sentinel, p);
        sentinel.next = newNode;
        p.prev = newNode;
    }


    public void addLast(T item) {
        size++;
        Node p = last.prev;
        Node newNode = new Node(item, p, last);
        p.next = newNode;
        last.prev = newNode;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = sentinel;
        for (int i = 0; i < size; i++) {
            System.out.println(p.next.item);
            p = p.next;
        }
    }


    public T removeFirst() {
        if (size == 0) {
            System.out.println("deque is empty");
            return null;
        }
        size--;
        T item = (T) sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        return item;
    }


    public T removeLast() {
        if (size == 0) {
            System.out.println("deque is empty");
            return null;
        }
        size--;
        T item = last.prev.item;
        last.prev = last.prev.prev;
        last.prev.next = last;
        return item;
    }

    public T get(int index) {
        Node p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        return getRecursiveHelper(index, sentinel.next);
    }

    private T getRecursiveHelper(int index, Node node) {
        if (index == 0) {
            return node.item;
        }
        return getRecursiveHelper(index - 1, node.next);
    }
}
