package custom.collections;

public class SortedLinkedList <E extends Comparable<E>> implements List<E> {
    public static final String NULL_MESSAGE_ERROR = "Null values are not allowed";
    public static final String INDEX_OUTBOUNDS_MESSAGE_ERROR = "Index out of bounds";

    private Node<E> root;
    private int size;

    public SortedLinkedList() {
        this.size = 0;
    }

    public int size() {
        return size;
    }

    @Override
    public void add(E e) {
        if(e == null) throw new NullPointerException(NULL_MESSAGE_ERROR);

        if(root == null) {
            root = new Node<>(e);
        }else{
            addNode(e);
        }
        size++;
    }

    private void addNode(E e) {
        Node currentNode = root;
        Node newNode = new Node<>(e);
        Node prevNode = null;

        while(currentNode != null) {
            if(newNode.compareValues(currentNode.getValue()) <= 0){
                if(prevNode == null) {
                    root = newNode;
                    newNode.setNext(currentNode);
                }else{
                    prevNode.setNext(newNode);
                    newNode.setNext(currentNode);
                }
                return;
            }else if(newNode.compareValues(currentNode.getValue()) > 0){
                if(currentNode.getNext() == null){
                    currentNode.setNext(newNode);
                    return;
                }else if(newNode.compareValues(currentNode.getNext().getValue()) <= 0){
                    newNode.setNext(currentNode.getNext());
                    currentNode.setNext(newNode);
                    return;
                }
            }

            prevNode = currentNode;
            currentNode = currentNode.getNext();
        }
    }

    @Override
    public boolean remove(int index) {
        if(index > size() || index < 0)
            throw new ArrayIndexOutOfBoundsException(INDEX_OUTBOUNDS_MESSAGE_ERROR);

        int currentIndex = 0;
        Node currentNode = root;
        Node prevNode = null;

        while(currentNode != null){
            if(currentIndex == index) {
                if(prevNode == null){
                    root = currentNode.getNext();
                }else{
                    prevNode.setNext(currentNode.getNext());
                }
                size--;
                return true;
            }

            prevNode = currentNode;
            currentNode = currentNode.getNext();
            currentIndex++;
        }
        return false;
    }

    @Override
    public E get(int index) {
        if(index > size()  || index < 0)
            throw new ArrayIndexOutOfBoundsException(INDEX_OUTBOUNDS_MESSAGE_ERROR);

        int currentIndex = 0;
        Node currentNode = root;

        while(currentNode != null){
            if(currentIndex == index){
                return (E) currentNode.getValue();
            }
            currentNode = currentNode.getNext();
            currentIndex++;
        }

        return null;
    }

    public E getFirst() {
        if(size == 0) return null;

        return root.getValue();
    }

    public Integer getIndexOf(E o) {
        if(o == null) throw new NullPointerException(NULL_MESSAGE_ERROR);

        int currentIndex = 0;
        Node currentNode = root;

        while(currentNode != null) {
            if(currentNode.compareValues(o) == 0)
                return currentIndex;

            currentIndex++;
            currentNode = currentNode.getNext();
        }

        return null;
    }

    public void printElements() {
        Node currentNode = root;

        while(currentNode != null) {
            System.out.print(currentNode.getValue() + " -> ");
            currentNode = currentNode.getNext();
        }

        System.out.println("null");
    }

}
