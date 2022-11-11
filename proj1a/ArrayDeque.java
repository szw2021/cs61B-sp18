public class ArrayDeque<T> {

    private T[] deque;
    private int next = 4;
    private int prev = 3;
    private int size = 0;
    private int count = 8;


    public ArrayDeque() {
        deque = (T[]) new Object[8];

    }

    private void resize() {
        T[] newDeque = (T[]) new Object[count * 2];
        int first = (prev + 1) % count;
        for (int i = 0; i < size; i++) {
            newDeque[i] = deque[first];
            first = (first + 1) % count;
        }
        deque = newDeque;
        count = count * 2;
        next = size;
        prev = count - 1;
    }

    private void resizeDown() {
        T[] newDeque = (T[]) new Object[count / 2];
        int first = (prev + 1) % count;
        for (int i = 0; i < size; i++) {
            newDeque[i] = deque[first];
            first = (first + 1) % count;
        }
        deque = newDeque;
        count = count / 2;
        next = size;
        prev = count - 1;
    }

    public void addFirst(T item) {

        if (size == count) {
            resize();
        }
        size++;
        deque[prev--] = item;
        if (prev < 0) {
            prev += count;
        }
    }

    public void addLast(T item) {
        if (size == count) {
            resize();
        }
        size++;
        deque[next++] = item;
        if (next >= count) {
            next -= count;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int first = (prev + 1) % count;
        for (int i = 0; i < size; i++) {
            System.out.println(deque[first]);
            first = (first + 1) % count;
        }
    }

    public T removeFirst() {
        if (size == 0) {
            System.out.println("Deque is Empty");
            return null;
        }
        size--;
        ++prev;
        if (prev >= count) {
            prev -= count;
        }
        T item = deque[prev];
        if (size < (count / 4)) {
            resizeDown();
        }
        return item;
    }


    public T removeLast() {
        if (size == 0) {
            System.out.println("Deque is Empty");
            return null;
        }
        size--;
        --next;
        if (next < 0) {
            next += count;
        }
        T item = deque[next];
        if (size < (count / 4)) {
            resizeDown();
        }
        return item;
    }

    public T get(int index) {
        int first = (prev + 1) % count;
        return deque[(index + first) % count];
    }

}
