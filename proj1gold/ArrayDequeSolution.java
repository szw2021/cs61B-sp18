import java.util.LinkedList;

/**
 * Isn't this solution kinda... cheating? Yes.
 * The aesthete will be especially alarmed by the fact that this
 * supposed ArrayDeque is actually using a LinkedList. SAD!
 */
public class ArrayDequeSolution<Item> extends LinkedList<Item> {
    public void printDeque() {
        System.out.println("dummy");
    }

    public Item getRecursive(int i) {
        return get(i);
    }

    public Item removeFirst() {
        try {
            return super.removeFirst();
        } catch (Exception e) {
            return null;
        }
    }

    public Item removeLast() {
        try {
            return super.removeLast();
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        ArrayDequeSolution<Integer> sol = new ArrayDequeSolution<>();
        sol.addLast(0);
        sol.addFirst(1);
        sol.addFirst(2);
        sol.addFirst(3);
        sol.addLast(4);
        sol.removeFirst();
        sol.addLast(6);
        sol.addLast(7);
        sol.addFirst(8);
        sol.addFirst(9);
        sol.removeLast();
        sol.addFirst(11);
        sol.addLast(12);
        System.out.println(sol.get(8));

    }
}
