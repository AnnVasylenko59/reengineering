package ua.edu.sumdu.reengineering.lab3;

import java.util.NoSuchElementException;

public final class Empty extends FunList {
    private static final Empty INSTANCE = new Empty();
    private Empty() {}
    public static Empty instance() {
        return INSTANCE;
    }

    @Override
    public boolean isEmpty() { return true; }

    @Override
    public int head() { throw new NoSuchElementException("head() requires a non-empty list"); }

    @Override
    public FunList tail() { throw new NoSuchElementException("tail() requires a non-empty list"); }

    @Override
    public FunList append(FunList other) {
        if (other == null) throw new NullPointerException("other list cannot be null");
        return other;
    }

    @Override
    public FunList insertInOrder(int value) {
        return new Cons(value, this);
    }

    @Override
    public FunList sort() { return this; }

    @Override
    protected void appendTo(StringBuilder builder) {
        // порожній список нічого не додає
    }
}