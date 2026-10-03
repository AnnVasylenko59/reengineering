package ua.edu.sumdu.reengineering.lab3;

import java.util.Objects;

public final class Cons extends FunList {
    private final int head;
    private final FunList tail;

    public Cons(int head, FunList tail) {
        this.head = head;
        this.tail = Objects.requireNonNull(tail);
    }

    public Cons(int head) {
        this(head, Empty.instance());
    }

    @Override
    public boolean isEmpty() { return false; }

    @Override
    public int head() { return head; }

    @Override
    public FunList tail() { return tail; }

    @Override
    public FunList append(FunList other) {
        if (other == null) throw new NullPointerException("other list cannot be null");
        return new Cons(head, tail.append(other));
    }

    @Override
    public FunList insertInOrder(int value) {
        if (value <= head) {
            return new Cons(value, this);
        } else {
            return new Cons(head, tail.insertInOrder(value));
        }
    }

    @Override
    public FunList sort() {
        return tail.sort().insertInOrder(head);
    }

    @Override
    protected void appendTo(StringBuilder builder) {
        builder.append(head);
        if (!tail.isEmpty()) {
            builder.append(" ");
            tail.appendTo(builder);
        }
    }
}