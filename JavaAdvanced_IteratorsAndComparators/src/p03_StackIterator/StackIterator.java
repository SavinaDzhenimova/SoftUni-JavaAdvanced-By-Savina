package p03_StackIterator;

import java.util.ArrayDeque;
import java.util.Iterator;

public class StackIterator implements Iterable<Integer> {
    private Integer[] elements;
    private int currentIndex = 0;

    public StackIterator() {
        this.elements = new Integer[20];
        this.currentIndex = 0;
    }

    public void push(int element) {
        this.elements[this.currentIndex++] = element;
    }

    public int pop() {
        if (currentIndex == 0) {
            throw new IllegalStateException("No elements");
        }
        Integer element = this.elements[this.currentIndex - 1];
        this.elements[this.currentIndex - 1] = null;
        this.currentIndex--;
        return element;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<Integer> {
        int index = currentIndex - 1;
        @Override
        public boolean hasNext() {
            return this.index >= 0;
        }

        @Override
        public Integer next() {
            return elements[index--];
        }
    }
}