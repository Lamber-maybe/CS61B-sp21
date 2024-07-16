package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        BuggyAList<Integer> listB = new BuggyAList<>();
        AListNoResizing<Integer> listA = new AListNoResizing<>();

        listB.addLast(4);
        listA.addLast(4);
        assertEquals(listA.size(), listB.size());

        listB.addLast(5);
        listA.addLast(5);
        assertEquals(listA.size(), listB.size());

        listB.addLast(6);
        listA.addLast(6);
        assertEquals(listA.size(), listB.size());

        listB.removeLast();
        listA.removeLast();
        assertEquals(listA.size(), listB.size());

        listB.removeLast();
        listA.removeLast();
        assertEquals(listA.size(), listB.size());

        listB.removeLast();
        listA.removeLast();
        assertEquals(listA.size(), listB.size());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> listB = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                listB.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int sizeB = listB.size();
                assertEquals(size, sizeB);
            } else if (operationNumber == 2) {
                // getLast
                if (L.size() == 0 || listB.size() == 0) {
                    continue;
                }
                int lastItem = L.getLast();
                int lastItemB = listB.getLast();
                assertEquals(lastItem, lastItemB);
            } else if (operationNumber == 3) {
                // removeLast
                if (L.size() == 0 || listB.size() == 0) {
                    continue;
                }
                L.removeLast();
                listB.removeLast();
            }
        }
    }
}
