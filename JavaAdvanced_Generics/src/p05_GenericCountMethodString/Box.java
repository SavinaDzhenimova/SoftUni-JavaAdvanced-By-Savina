package p05_GenericCountMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private final List<T> list;

    public Box() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        list.add(element);
    }

    public int getGreaterElementsCount(T element) {
        int count = 0;

        for (T item : list) {
            if (item.compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }
}