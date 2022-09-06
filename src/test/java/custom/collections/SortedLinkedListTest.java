package custom.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SortedLinkedListTest {
    SortedLinkedList<Integer> sortedIntegerLinkedList;
    SortedLinkedList<String> sortedStringLinkedList;

    @BeforeEach
    void setUp() {
        sortedIntegerLinkedList = new SortedLinkedList<>();
        sortedStringLinkedList = new SortedLinkedList<>();
    }

    @Test
    void sizeTest() {
        addIntegerValues();
        assertEquals(6, sortedIntegerLinkedList.size());
    }

    @Test
    void addIntegerTest(){
        addIntegerValues();
        assertEquals(-3, sortedIntegerLinkedList.get(0));
        assertEquals(1, sortedIntegerLinkedList.get(1));
        assertEquals(3, sortedIntegerLinkedList.get(2));
        assertEquals(6, sortedIntegerLinkedList.size());
    }

    @Test
    void addStringTest() {
        addStringValues();

        String expectedFirstValue = "apple";
        String expectedSecondValue = "Apple";

        assertEquals(7, sortedStringLinkedList.size());
        assertEquals(expectedFirstValue, sortedStringLinkedList.get(0));
        assertEquals(expectedSecondValue, sortedStringLinkedList.get(1));
    }

    @Test
    void whenNullPointerExceptionThrown_addTest() {
        addStringValues();

        NullPointerException exception = assertThrows(NullPointerException.class, () ->
                sortedStringLinkedList.add(null));

        String expectedMessage = "Null values are not allowed";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void getIntegerTest() {
        addIntegerValues();

        Integer expectedValue = -3;

        assertEquals(expectedValue, sortedIntegerLinkedList.get(0));
        assertNotNull(sortedIntegerLinkedList.get(2));
    }

    @Test
    public void getStringTest() {
        addStringValues();

        String expectedValue = "Hello";

        assertEquals(expectedValue, sortedStringLinkedList.get(2));
        assertNotNull(sortedStringLinkedList.get(4));
    }

    @Test
    public void whenArrayIndexOutOfBoundsExceptionThrown_getTest() {
        addIntegerTest();

        Integer outOfIndex = 10;

        ArrayIndexOutOfBoundsException exception = assertThrows(ArrayIndexOutOfBoundsException.class, () ->
            sortedIntegerLinkedList.get(outOfIndex));

        String expectedMessage = "Index out of bounds";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenArrayIndexOutOfBoundsExceptionThrownNegativeValue_getTest() {
        addIntegerTest();

        Integer outOfIndex = -20;

        ArrayIndexOutOfBoundsException exception = assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                sortedIntegerLinkedList.get(outOfIndex));

        String expectedMessage = "Index out of bounds";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void removeIntegerTest() {
        addIntegerValues();

        sortedIntegerLinkedList.remove(2);
        Integer expectedSize = 5;
        Integer currentSize = sortedIntegerLinkedList.size();

        assertEquals(expectedSize, currentSize);
        assertTrue(sortedIntegerLinkedList.get(2) == 5);
    }

    @Test
    public void removeStringTest() {
        addStringValues();

        sortedStringLinkedList.remove(2);
        Integer expectedSize = 6;
        Integer currentSize = sortedStringLinkedList.size();
        String expectedValue = "Java";
        String currentValue = sortedStringLinkedList.get(2);

        assertEquals(expectedSize, currentSize);
        assertEquals(expectedValue, currentValue);
    }

    @Test
    public void whenArrayIndexOutOfBoundsExceptionThrown_removeTest() {
        addIntegerTest();

        Integer outOfIndex = 10;

        ArrayIndexOutOfBoundsException exception = assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                sortedIntegerLinkedList.get(outOfIndex));

        String expectedMessage = "Index out of bounds";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void whenArrayIndexOutOfBoundsExceptionThrownNegativeValue_removeTest() {
        addIntegerTest();

        Integer outOfIndex = -24;

        ArrayIndexOutOfBoundsException exception = assertThrows(ArrayIndexOutOfBoundsException.class, () ->
                sortedIntegerLinkedList.get(outOfIndex));

        String expectedMessage = "Index out of bounds";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void getFirstIntegerTest() {
        addIntegerValues();

        Integer expectedInt = -3;
        Integer actualInt = sortedIntegerLinkedList.getFirst();
        assertEquals(expectedInt, actualInt);
    }

    @Test
    public void getFirstStringTest() {
        addStringValues();

        String expectedString = "apple";
        String actualString = sortedStringLinkedList.getFirst();
        assertEquals(expectedString, actualString);
    }

    @Test
    public void getIndexOfIntegerTest() {
        addIntegerValues();

        Integer expectedIndex = 3;
        Integer actualIndex = sortedIntegerLinkedList.getIndexOf(5);

        assertEquals(expectedIndex, actualIndex);
        assertEquals(null, sortedIntegerLinkedList.getIndexOf(100));
    }

    @Test
    public void getIndexOfStringTest() {
        addStringValues();

        Integer expectedIndex = 5;
        Integer actualIndex = sortedStringLinkedList.getIndexOf("World");

        assertEquals(expectedIndex, actualIndex);
        assertEquals(null, sortedStringLinkedList.getIndexOf("world"));
    }

    @Test
    public void whenNullPointerExceptionThrown_getIndexOfTest() {
        addIntegerValues();

        NullPointerException exception = assertThrows(NullPointerException.class, () ->
                sortedIntegerLinkedList.getIndexOf(null));

        String expectedMessage = "Null values are not allowed";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    private void addIntegerValues() {
        sortedIntegerLinkedList.add(5);
        sortedIntegerLinkedList.add(3);
        sortedIntegerLinkedList.add(8);
        sortedIntegerLinkedList.add(-3);
        sortedIntegerLinkedList.add(1);
        sortedIntegerLinkedList.add(5);
    }

    private void addStringValues() {
        sortedStringLinkedList.add("Hello");
        sortedStringLinkedList.add("World");
        sortedStringLinkedList.add("People");
        sortedStringLinkedList.add("Apple");
        sortedStringLinkedList.add("Yellow");
        sortedStringLinkedList.add("Java");
        sortedStringLinkedList.add("apple");
    }

}