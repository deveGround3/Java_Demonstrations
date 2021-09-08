
/**
 *
 * @author Nicholas Schons
 */
/*
 *CSCI-310, Nicholas Schons
 */
public class MyArrayListOp<E> extends MyArrayList<E> {
    public MyArrayListOp() {
        arr = (E[]) new Object[INITIAL_CAPACITY];
    }
    public MyArrayListOp(E[] eArr) {
        if (eArr.length == 0){
            arr = (E[]) new Object[INITIAL_CAPACITY];
        } else {
            arr = (E[]) new Object[eArr.length];
            System.arraycopy(eArr, 0, arr, 0, eArr.length);
            size = arr.length;
        }
    }
    @Override
    public void clear() {
        arr = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }
    @Override
    public E removeLast() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        E removed = this.get(size() - 1);
        size--;
        return removed;
    }
}
