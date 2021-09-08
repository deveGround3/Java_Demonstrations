/*
* CSCI-310, Nicholas Schons,
* Spring 2019, HW 4 Part 3
*/
public class MyLinkedListOp<E> extends MyLinkedList<E> {
    public MyLinkedListOp() {
        head = null;
        tail = null;
    }
    public MyLinkedListOp(E[] eArr) {
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
        SNode current = head;
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
