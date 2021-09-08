
public class DNode<E> {
    protected E e;
    protected DNode next;
    protected DNode previous;
    
    protected DNode(E e) {
        this.e = e;
        next = null;
        previous = null;
    }
}
