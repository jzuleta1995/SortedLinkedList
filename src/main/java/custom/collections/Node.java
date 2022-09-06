package custom.collections;

import java.text.Collator;

public class Node<E extends Comparable<E>> {
    private static final Collator collator = Collator.getInstance();
    private E value;
    private Node<E> next;

    public Node(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
    public int compareValues(E o) {
        if(o == null) throw new NullPointerException();

        if(o instanceof String)
            return collator.compare(this.value, o);

        return this.value.compareTo(o);
    }
}
