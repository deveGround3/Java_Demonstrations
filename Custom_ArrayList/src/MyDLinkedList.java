/*
*
*/
public class MyDLinkedList<E> extends MyAbstractList<E> {
    protected DNode<E> head;
    protected DNode<E> tail;
    public MyDLinkedList() {
        head = null;
        tail = null;
    }
    public MyDLinkedList(E[] eArr) {
        for (int i = 0; i < eArr.length; i++) {
           add(i, eArr[i]);
        }
    }
    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        if (i < 0 || i > size()) {
            throw new IndexOutOfBoundsException("The index " + i + "  is not valid");
        }
        DNode temp = new DNode(e);
        if (isEmpty()) {
            head = tail = temp;
        } else if (i == 0) {
            temp.next = head;
            head.previous = temp;   
            head = temp;
        } else if (i == size()) {
            tail.next = temp;
            temp.previous = tail;
            tail = temp;
        } else {
            DNode current = head;
            for (int i2 = 0; i2 < i; i2++) {    // i - 1?
                current = current.next;
            }
            current.previous.next = temp;
            temp.next = current;
            temp.previous = current.previous;
            current.previous = temp;
        }
        size++;
    }

    @Override
    public int firstIndexOf(E e) {
        DNode current = head;
        for (int i = 0; i < size; i++) {
            if (current.e == e) {
                return i;
            }
            current = current.next;
        }
        return -1;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        E temp;
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index " + i + " is not valid.");
        }
        if (i == 0) {
            temp = head.e;
        } else if (i == size() - 1) {
            temp = tail.e;
        } else {
            DNode <E> current = head;
            for (int j = 0; j < i; j++) {
                current = current.next;
            }
            temp = current.e; 
        }
        return temp;
    }

    @Override
    public int lastIndexOf(E e) {
        DNode current = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (current.e == e) {
                return i;
            }
            current = current.previous;
        }
        return -1;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Index " + i + " is not valid.");
        }
        E temp;
        if (size == 1) {
            temp = head.e;
            head = tail = null;
        } else if (i == 0) {
            temp = head.e;
            head = head.next;
            head.previous.next = null;
            head.previous = null;
        } else if (i == size() - 1) {
            temp = tail.e;
            tail = tail.previous;
            tail.next.previous = null;
            tail.next = null;
        } else {
            DNode<E> current = head;
            for (int m = 0; m < i; m++) {
                current = current.next;
            }
            temp = current.e;
            current.previous.next = current.next;
            current.next.previous = current.previous;
            current.previous = null;
            current.next = null;
        }
        size--;
        return temp;
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        if (i < 0|| i >= size) {
            throw new IndexOutOfBoundsException("Index " + i + "is out of bounds." );
        }
        E temp;
        if (i == 0) {
            temp = head.e;
            head.e = e;
        } else if (i == size - 1) {
            temp = tail.e;
            tail.e = e;
        } else {
            DNode <E> current = head;
            for (int j = 0; j < i; j++) {
                current = current.next;
            }
            temp = current.e;
            current.e = e;
        }
        return temp;
    }
}
