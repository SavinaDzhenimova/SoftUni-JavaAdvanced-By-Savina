package p09_CustomListIterator;

import java.util.*;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {
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

    public List<T> toSort() { return  this.list; }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < list.size();
            }

            @Override
            public T next() {
                T element = list.get(index);
                index++;
                return element;
            }
        };
    }
}