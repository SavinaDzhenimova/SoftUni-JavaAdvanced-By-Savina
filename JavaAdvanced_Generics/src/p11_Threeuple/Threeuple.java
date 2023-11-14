package p11_Threeuple;

public class Threeuple<T, E, R> {
    private final T item1;
    private final E item2;
    private final R item3;

    public Threeuple(T item1, E item2, R item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s -> %s", this.item1, this.item2, this.item3);
    }
}