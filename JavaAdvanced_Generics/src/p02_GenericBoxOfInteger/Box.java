package p02_GenericBoxOfInteger;

public class Box<T> {
    private final T value;

    public Box(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s: %s", this.value.getClass().getName(), value);
    }
}