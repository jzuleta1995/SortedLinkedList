package custom.collections;

public class Main {

    public static void main(String[] args) {
        clientStringSortedLinkedList();
        clientIntegerSortedLinkedList();
    }

    public static void clientIntegerSortedLinkedList() {
        SortedLinkedList<Integer> sortedLinkedList = new SortedLinkedList<>();
        sortedLinkedList.add(5);
        sortedLinkedList.add(3);
        sortedLinkedList.add(8);
        sortedLinkedList.add(1);
        sortedLinkedList.add(-100);
        sortedLinkedList.add(2);
        sortedLinkedList.add(-5);
        sortedLinkedList.add(5);
        sortedLinkedList.add(9);
        sortedLinkedList.printElements();
    }

    public static void clientStringSortedLinkedList() {
        SortedLinkedList<String> sortedLinkedList = new SortedLinkedList<>();
        sortedLinkedList.add("Hello");
        sortedLinkedList.add("World");
        sortedLinkedList.add("People");
        sortedLinkedList.add("partner");
        sortedLinkedList.add("software");
        sortedLinkedList.add("Apple");
        sortedLinkedList.add("Yellow");
        sortedLinkedList.add("Halo");
        sortedLinkedList.add("apple");
        sortedLinkedList.printElements();
    }
}
