package ua.edu.sumdu.reengineering.lab3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FunListTest {
    @Test
    void emptyShouldBeSingleton() {
        assertSame(Empty.instance(), Empty.instance());
    }

    @Test
    void oneArgumentConstructorShouldUseEmptyTail() {
        FunList list = new Cons(5);
        assertEquals(5, list.head());
        assertSame(Empty.instance(), list.tail());
    }

    @Test
    void appendShouldPreserveSources() {
        FunList left = new Cons(1, new Cons(2));
        FunList right = new Cons(3);
        FunList result = left.append(right);
        assertEquals("(1 2 3)", result.toString());
        assertEquals("(1 2)", left.toString());
        assertEquals("(3)", right.toString());
    }

    @Test
    void appendShouldRejectNull() {
        FunList list = new Cons(1);
        assertThrows(NullPointerException.class, () -> list.append(null));
    }

    @Test
    void emptyHeadShouldThrow() {
        assertThrows(java.util.NoSuchElementException.class, () -> Empty.instance().head());
    }

    @Test
    void appendWithEmptyShouldPreserveListOrEmpty() {
        FunList empty = Empty.instance();
        FunList list = new Cons(1, new Cons(2));

        FunList emptyAppendedWithList = empty.append(list);
        assertEquals("(1 2)", emptyAppendedWithList.toString());

        FunList listAppendedWithEmpty = list.append(empty);
        assertEquals("(1 2)", listAppendedWithEmpty.toString());
        assertEquals("(1 2)", list.toString());

        FunList emptyAppendedWithEmpty = empty.append(Empty.instance());
        assertSame(Empty.instance(), emptyAppendedWithEmpty);
    }

    @Test
    void insertInOrderAtBeginningShouldPrependElement() {
        FunList list = new Cons(3, new Cons(7));

        FunList insertedSmaller = list.insertInOrder(1);
        assertEquals("(1 3 7)", insertedSmaller.toString());

        FunList insertedEqual = list.insertInOrder(3);
        assertEquals("(3 3 7)", insertedEqual.toString());

        assertEquals("(3 7)", list.toString());
    }

    @Test
    void insertInOrderInMiddleAndAtEndShouldPlaceElementInCorrectPosition() {
        FunList list = new Cons(1, new Cons(4, new Cons(8)));

        FunList insertedMiddle = list.insertInOrder(5);
        assertEquals("(1 4 5 8)", insertedMiddle.toString());

        FunList insertedEnd = list.insertInOrder(10);
        assertEquals("(1 4 8 10)", insertedEnd.toString());

        assertEquals("(1 4 8)", list.toString());
    }

    @Test
    void sortWithDuplicateValuesShouldReturnSortedList() {
        FunList list = new Cons(3, new Cons(1, new Cons(2, new Cons(1, new Cons(3)))));

        FunList sorted = list.sort();
        assertEquals("(1 1 2 3 3)", sorted.toString());
        assertEquals("(3 1 2 1 3)", list.toString());
    }
}