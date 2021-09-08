
/**
 *
 * @author Nicholas Schons
 */

/*
* CSCI-310, Nicholas Schons,
*/
public abstract class MyAbstractList<E> implements MyList<E> {
    protected int size;
    
    @Override
    public void add(E e) {
        addLast(e);
    }
    @Override
    public void addFirst(E e) {
        add(0, e);
    }
    @Override
    public void addLast(E e) {
        add(size(), e);
    }
    @Override
    public void clear() {
        size = 0;
    }
    @Override
    public boolean contains(E e){
        if (firstIndexOf(e) == -1) {    //Might replace with get later.
            return false;
        }
        return true;
    }
    @Override
    public E getFirst() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("The list is empty, so finding the first element is not possible.");
        }
        return get(0);
    }
    @Override
    public E getLast() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("The list is empty, so finding the last element is not possible.");
        }
        return get(size() - 1);
    }
    @Override
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        } 
        return false;
    }
    @Override
    public E removeFirst() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("The list is empty, so removimg the first element is not possible.");
        }
        return remove(0);
    }
    @Override
    public E removeLast() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("The list is empty, so removing the last element is not possible.");
        }
        return remove(size() - 1);
    }
    @Override
    public E setFirst(E e) throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("The list is empty, so seting the first element is not possible.");
        }
        return set(0, e);
    }
    @Override
    public E setLast(E e) throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("The list is empty, so seting the last element is not possible.");
        }
        return set(size() - 1, e);
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public String toString() {
        String s = "";
        boolean firstI = true;
        if (isEmpty()) {
            return "[]";
        }
        for (int i = 0; i < size(); i++) { //?
            if (firstI) {
                s += "[";
                firstI = false;
            } else {
                s += ", ";
            }
            s += get(i);
        }
        s += "]";
        return s;
    }
}
