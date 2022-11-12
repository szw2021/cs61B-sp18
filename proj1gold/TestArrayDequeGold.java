import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestArrayDequeGold {

    StudentArrayDeque<Integer> studentArrayDeque = new StudentArrayDeque();
    ArrayDequeSolution<Integer> arrayDequeSolution = new ArrayDequeSolution<>();

    @Test
    public void test() {

        int num = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();
            if (numberBetweenZeroAndOne < 0.25) {
                num++;
                studentArrayDeque.addFirst(i);
                arrayDequeSolution.addFirst(i);
                sb.append("addFirst(").append(i).append(")\n");
                assertEquals(sb.toString(), arrayDequeSolution.get(0), studentArrayDeque.get(0));
            } else if (numberBetweenZeroAndOne < 0.5){
                num++;
                studentArrayDeque.addLast(i);
                arrayDequeSolution.addLast(i);
                sb.append("addLast(").append(i).append(")\n");
                assertEquals(sb.toString(), arrayDequeSolution.get(num - 1), studentArrayDeque.get(num - 1));
            } else if (numberBetweenZeroAndOne < 0.75) {
                if (num == 0) {
                    continue;
                }
                num--;
                Integer stu = studentArrayDeque.removeFirst();
                Integer sol = arrayDequeSolution.removeFirst();
                sb.append("removeFirst()\n");
                assertEquals(sb.toString(), sol, stu);
            } else {
                if (num == 0) {
                    continue;
                }
                num--;
                Integer stu = studentArrayDeque.removeLast();
                Integer sol = arrayDequeSolution.removeLast();
                sb.append("removeLast()\n");
                assertEquals(sb.toString(), sol, stu);
            }
        }

    }

}
