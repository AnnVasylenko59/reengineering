package ua.edu.sumdu.reengineering.lab3;

/**
 * Незмінюваний навчальний список цілих чисел.
 * @author Ваше ім'я
 * @since 2026
 */
public abstract sealed class FunList permits Empty, Cons {
    public abstract boolean isEmpty();
    public abstract int head();
    public abstract FunList tail();
    public abstract FunList append(FunList other);
    public abstract FunList insertInOrder(int value);
    public abstract FunList sort();
    protected abstract void appendTo(StringBuilder builder);

    @Override
    public final String toString() {
        StringBuilder builder = new StringBuilder("(");
        appendTo(builder);
        return builder.append(")").toString();
    }
}