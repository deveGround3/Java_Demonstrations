
/*
 *CSCI-310, Nicholas Schons
 */
public class MyArrayList<E> extends MyAbstractList<E> {
    protected E[] arr;
    public static final int INITIAL_CAPACITY = 4;
            
    public MyArrayList() {
        arr = (E[]) new Object[INITIAL_CAPACITY];
    }
    public MyArrayList(E[] eArr) {  //?
        if (eArr.length == 0){
            arr = (E[]) new Object[INITIAL_CAPACITY];
        } else {
            arr = (E[]) new Object[eArr.length];
            System.arraycopy(eArr, 0, arr, 0, eArr.length);
            //System.out.println(Arrays.toString(arr));
            size = arr.length;
            /*for (int i = 0; i < eArr.length; i++) {
                size++;
                set(i, eArr[i]);
            } */
        }
    }
    
    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        if (i > size() || i < 0) {
            String message = "The index " + i + " is not valid.";
            throw new IndexOutOfBoundsException(message);
        }
        if (size == this.capacity()) {
            ensureCapacity(this.capacity() * 2);
        }
        System.arraycopy(arr, i, arr, i + 1, size - i);
        arr[i] = e;
        size++;
    }
    
    public int capacity () {
        return arr.length;
    }
    
    public void ensureCapacity(int minimum) throws IllegalArgumentException {
        if (minimum <= 0) {
            throw new IllegalArgumentException("Minimum capacity input is not valid");
        }
        if (this.capacity() < minimum) {
            E[] temp = (E[]) new Object[minimum];
            System.arraycopy(arr, 0, temp, 0, this.size());
            arr = temp;
        }
    }

    @Override
    public int firstIndexOf(E e) {
        for (int j = 0; j < size; j++) {
            if (arr[j].equals(e)) {
                return j;
            }
        }
        return -1;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        if (i > size - 1 || i < 0) {
            String message = "The index " + i + " is not valid.";
            throw new IndexOutOfBoundsException(message);
        }
        return arr[i];
    }

    @Override
    public int lastIndexOf(E e) {
        if (this.isEmpty()) {
            return -1;
        }
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i > size() - 1) {
            throw new IndexOutOfBoundsException("Index " + i + " is not a valid index");
        }
        E removed = this.get(i);
        if (i < size() - 1) {   //checks to see if i is not the very last index in size
             System.arraycopy(arr, i + 1, arr, i, size - i - 1);
        }
        size--;
        return removed;
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        if (i < 0 || i > size - 1) {
            throw new IndexOutOfBoundsException("Index " + i + " not a valid index");
        }
        E old = arr[i];
        arr[i] = e;
        return old;
    }
    
    public void trimToSize() {
        if (this.capacity() > size) {
            E[] temp = (E[]) new Object[size];
            System.arraycopy(arr, 0, temp, 0, size);
            arr = temp;
        }
    }
}
