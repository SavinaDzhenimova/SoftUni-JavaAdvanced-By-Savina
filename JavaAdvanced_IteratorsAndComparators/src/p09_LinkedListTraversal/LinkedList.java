package p09_LinkedListTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class LinkedList<T> {
    public class Node {
        T element;
        Node next;
        Node prev;

        public Node(T element) {
            this.element = element;
        }
    }

    private List<Node> elements;
    private Node lastElement;
    private Node firstElement;

    public LinkedList() {
        this.elements = new ArrayList<>(500);
    }

    public void add(T element) {
        Node newNode = new Node(element);

        if (this.elements.size() == 0) {
            this.firstElement = newNode;
            this.lastElement = newNode;
        } else {
            this.lastElement.next = newNode;
            newNode.prev = this.lastElement;
            newNode.next = null;
        }

        this.elements.add(newNode);
        this.lastElement = newNode;
    }

    public void remove(T element) {
        checkEmpty();

        Node nodeToRemove = new Node(element);

        for (Node currentNode : this.elements) {
            if (currentNode.element == nodeToRemove.element) {
                int nodeToRemoveIndex = this.elements.indexOf(currentNode);

                if (nodeToRemoveIndex > 0 && nodeToRemoveIndex < this.elements.size() - 1) {
                    Node prevElement = this.elements.get(nodeToRemoveIndex - 1);
                    Node nextElement = this.elements.get(nodeToRemoveIndex + 1);

                    prevElement.next = nextElement;
                    nextElement.prev = prevElement;
                } else if (nodeToRemoveIndex == 0) {
                    Node nextElement = this.elements.get(nodeToRemoveIndex + 1);
                    this.firstElement = nextElement;
                    nextElement.prev = null;
                } else if (nodeToRemoveIndex == this.elements.size() - 1) {
                    Node prevElement = this.elements.get(nodeToRemoveIndex - 1);
                    this.lastElement = prevElement;
                    prevElement.next = null;
                }

                this.elements.remove(currentNode);
                break;
            }
        }
    }

    public int getSize() {
        return this.elements.size();
    }

    private void checkEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty!");
        }
    }

    public boolean isEmpty() {
        return this.elements.size() == 0;
    }

    public void forEach(Consumer<T> consumer) {
        Node currentNode = this.firstElement;

        while (currentNode != null) {
            consumer.accept(currentNode.element);
            currentNode = currentNode.next;
        }
    }
}