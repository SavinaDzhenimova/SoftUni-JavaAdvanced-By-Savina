import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class DoublyLinkedList<T> {
    class Node {
        T element;
        Node next;
        Node prev;

        public Node(T element) {
            this.element = element;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public void addFirst(T element) {
        Node newNode = new Node(element);

        if (this.size == 0) {
            this.head = this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.prev = newNode;
            this.head = newNode;
        }

        this.size++;
    }

    public void addLast(T element) {
        Node newNode = new Node(element);

        if (this.size == 0) {
            this.head = this.tail = newNode;
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
            this.tail = newNode;
        }

        this.size++;
    }

    public T get(int index) {
        checkIndex(index);
        Node currentNode;

        if (index <= this.size / 2) {
            currentNode = this.head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = this.tail;
            for (int i = this.size; i >= index; i--) {
                currentNode = currentNode.prev;
            }
        }

        return currentNode.element;
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException(
                    String.format("Index %d is out of bounds for size %d.", index, this.size));
        }
    }

    public T removeFirst() {
        checkEmpty();

        T element = this.head.element;
        this.head = this.head.next;
        if (this.head == null) {
            this.tail = null;
        } else {
            this.head.prev = null;
        }

        this.size--;
        return element;
    }

    public T removeLast() {
        checkEmpty();

        T element = this.head.element;
        this.tail = this.tail.prev;
        if (this.tail == null) {
            this.head = null;
        } else {
            this.tail.next = null;
        }

        this.size--;
        return element;
    }

    private void checkEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty!");
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void forEach(Consumer<T> consumer) {
        Node currentNode = this.head;

        while (currentNode != null) {
            consumer.accept(currentNode.element);
            currentNode = currentNode.next;
        }
    }
 
    public Object[] toArray() {
        Object[] array = new Object[this.size];
        int index = 0;

        Node currentNode = this.head;
        while (currentNode != null) {
            array[index++] = currentNode.element;
            currentNode = currentNode.next;
        }

        return array;
    }
}