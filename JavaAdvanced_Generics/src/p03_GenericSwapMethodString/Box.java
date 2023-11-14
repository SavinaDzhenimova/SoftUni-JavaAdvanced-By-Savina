package p03_GenericSwapMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private final List<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        list.add(element);
    }

    public void swap(int index1, int index2) {
        T firstElement = list.get(index1);
        T secondElement = list.get(index2);

        list.remove(index1);
        list.add(index1, secondElement);
        list.remove(index2);
        list.add(index2, firstElement);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : list) {
            sb.append(String.format("%s: %s", element.getClass().getName(), element)).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}