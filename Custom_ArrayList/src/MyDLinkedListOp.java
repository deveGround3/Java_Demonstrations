

/*
 * CSCI-310, Nicholas Schons,
 * Spring 2019, HW 4 Part 3
 */
public class MyDLinkedListOp<E> extends MyDLinkedList<E> {
    public MyDLinkedListOp() {
        head = null;
        tail = null;
    }
    public MyDLinkedListOp(E[] eArr) {
        for (int i = 0; i < eArr.length; i++) {
           add(i, eArr[i]);
        }
    }
    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }
    @Override
    public String toString() {
        String s = "[";
        boolean first = true;
        DNode current = head;
        while (current != null) {
            if (first) {
                s += current.e;
                first = false;
            } else {
                s += ", " + current.e;
            }
            current = current.next;
        }
        s += "]";
        return s;
    }
}
