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
}