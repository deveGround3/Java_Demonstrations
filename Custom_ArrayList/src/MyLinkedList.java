/*
* CSCI-310, Nicholas Schons,
* Spring 2019, HW 4 Part 3
*/
public class MyLinkedList<E> extends MyAbstractList<E> {
    protected SNode<E> head;
    protected SNode<E> tail;
    public MyLinkedList() {
        head = null;
        tail = null;
    }
    public MyLinkedList(E[] eArr) {
       for (int i = 0; i < eArr.length; i++) {
           add(i, eArr[i]);
       }
    }
    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException {
        if (i < 0 || i > size()) {
            throw new IndexOutOfBoundsException("The index " + i + "  is not valid");
        }
        SNode temp = new SNode(e);
        if (isEmpty()) {
            head = tail = temp;
        } else if (i == 0) {
            temp.next = head;
            head = temp;    //replaces the current head with temp
        } else if (i == size()) {
            tail.next = temp;
            tail = temp;
        } else {
            SNode current = head;
            for (int i2 = 0; i2 < i - 1; i2++) {
                current = current.next;
            }
            temp.next = current.next; //records the next SNode in the line for temp
            current.next = temp;
        }
        size++;
    }

    @Override
    public int firstIndexOf(E e) {
        SNode current = head;
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
        } else if (i == size - 1) {
            temp = tail.e;
        } else {
            SNode <E> current = head;
            for (int j = 0; j < i; j++) {
                current = current.next;
            }
            temp = current.e; 
        }
        return temp;
    }

    @Override
    public int lastIndexOf(E e) {
        int foundI = -1;
        SNode current = head;
        for (int i = 0; i < size; i++) {
            if (current.e == e) {
                foundI = i;
            }
            current = current.next;
        }
        return foundI;
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
            SNode Oldhead = head;
            head = head.next;
            Oldhead.next = null;
        } else if (i == size - 1) {
            temp = tail.e;
            SNode current = head;
            for (int j = 0; j < size - 2; j++) {
                current = current.next;
            }
            tail = current;
            tail.next = null;
        } else {
            SNode previous = null;
            SNode<E> current = head;
            for (int m = 0; m < i; m++) {
                previous = current;
                current = current.next;
            }
            temp = current.e;
            previous.next = current.next;
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
            SNode <E> current = head;
            for (int j = 0; j < i; j++) {
                current = current.next;
            }
            temp = current.e;
            current.e = e;
        }
        return temp;
    }
    
}
