package p02_Collection;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private List<String> list;
    private int currentIndex;

    public ListyIterator(String... list) {
        this.list = List.of(list);
        this.currentIndex = 0;
    }

    public boolean move() {
        if (hasNext()) {
            currentIndex++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return currentIndex < this.list.size() - 1;
    }

    public void print() {
        if (this.list.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
        System.out.println(this.list.get(this.currentIndex));
    }

    public void printAll() {

    }

    @Override
    public Iterator<String> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<String> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index < list.size();
        }

        @Override
        public String next() {
            return list.get(index++);
        }
    }
}