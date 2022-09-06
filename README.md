# SortedLinkedList
SortedLinkedList class is a linked list that keeps the values sorted

# Introduction
Simple data structure built from scratch in Java 8, It's based on a linked list that keeps the values sorted every time we add a new value.

## Table of contents
* [Classes](#classes)
* [Examples] (#examples)

## Classes
The custom.collections package contains the necessary classes to implement the SortedLinkedList class

### List Interface
Simple interface that contains add, remove and get methods to be implemented by the SortedLinkedList class.

```
public interface List<T> {
    void add(T t);
    boolean remove(int index);
    T get(int index);
}
```

### Node class
SortedLinkedList uses the node class to store values in the list and points to the next node out, allowing a linked list structure. It should be implemented with a class extending from the Comparable interface to compare and keep the values sorted.

```
public class Node<E extends Comparable<E>>
```

#### Properties
```
private static final Collator collator; //Variable used to compare Strings
private E value; //Variable to store values 
private Node<E> next; //Variable to point to the next node out 
```
#### Methods
```
 public E getValue() //Get actual value in the node
 public void setValue(E value) //Set a new value in the node
 public Node<E> getNext() //Get the next node 
 public void setNext(Node next) //Set a new next node
 public int compareValues(E o) //Compare values to keep sorted
```
### SortedLinkedList class
Data structure that Keeps a linked list sorted by values, it should be implemented with classes that extends from the Comparable interface.

```
public class SortedLinkedList <E extends Comparable<E>> implements List<E>
```

#### Properties

```
private Node<E> root; //Root value of the SortedLinkedList
private int size; //SortedLinkedList size. It increases when a value is added and decreases when it is removed
```
#### Methods

##### Size

Method to retrieve the length of the Linked List

```
public int size()
```
* Input: void
* Output: Returns The SortedLinkedList size


##### Add

Method to store a new value in a node and look up the correct index to place it in the list based on the compare method implemented by the object.

```
public void add(E e)
```
* Input: Object with the type defined in the sorted linked list creation.
* Output: void
* Throws: NullPointerException is thrown if the input is a null value

##### Remove

Method to remove the value that is placed in the required index.

```
public boolean remove(int index)
```
* Input: Index of the value to be removed.
* Output: returns a boolean that is true if the value was removed and false if it was not found.
* Throws: ArrayIndexOutOfBoundsException is thrown if the input is greater than the size of the list or less than zero.


##### Get

Method to retrieve the value that is placed in the required index.

```
public E get(int index)
```
* Input: Index of the value to be retrieved.
* Output: Returns the value found at the required index or null if the value was not found.
* Throws: ArrayIndexOutOfBoundsException is thrown if the input is greater than the size of the list or less than zero.

##### Get First

Method to get the root value.

```
public E getFirst()
```
* Input: void
* Output: Returns the value at the root position and null if the list does not contain any value.

##### Get Index Of

Method to get the index of the required value.

```
public Integer getIndexOf(E o)
```
* Input: Value required in the list
* Output: If the list cointains the value, the index is returned. Otherwise, returns null.
* Throws: NullPointerException is thrown if the input is a null value

#### Print Elements

Method to fetch and print all the elements of the list.

```
public void printElements()
```
* Input: void
* Output: void

## Examples

```
//Integer List
SortedLinkedList<Integer> sortedLinkedList = new SortedLinkedList<>();
//Add
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

//Size
sortedLinkedList.size();
//Get
sortedLinkedList.get(5);
//Remove
sortedLinkedList.remove(1);
//Size
sortedLinkedList.size();
//Get First
sortedLinkedList.getFirst();
//Get Index Of
sortedLinkedList.getIndexOf(8);

//Output
-100 -> -5 -> 1 -> 2 -> 3 -> 5 -> 5 -> 8 -> 9 -> null //Print
9 // Size
3 //Get
-100 -> 1 -> 2 -> 3 -> 5 -> 5 -> 8 -> 9 -> null  //Remove
8 //Size
-100 //Get First
6 //Get Index Of

//String List
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
// Output
apple -> Apple -> Halo -> Hello -> partner -> People -> software -> World -> Yellow -> null
```


