package p07_CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);
    }

    public T remove(int index) {
        return this.list.remove(index);
    }

    public boolean contains(T element) {
        return this.list.contains(element);
    }

    public void swap(int index1, int index2) {
        Collections.swap(this.list, index1, index2);
    }

    public long countGreaterThan(T element) {
        return this.list.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    public T getMax() {
        return this.list.stream().max(Comparator.naturalOrder()).orElse(null);
    }

    public T getMin() {
        return this.list.stream().min(Comparator.naturalOrder()).orElse(null);
    }

    public void print() {
        this.list.forEach(System.out::println);
    }
}