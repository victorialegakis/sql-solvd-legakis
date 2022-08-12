package hometask.two.generics;

public class CustomLinkedList<T> {


    class Node {
        T node;
        Node next;

        public Node(T node) {
            this.node = node;
        }

    }

    private Node head;
    private Node tail;

    public Node getHead() {
        return head;
    }

    public void addFirst(T node) {
        if (isEmpty()) {
            head = new Node(node);
            tail = head;
            return;
        }
        Node newNode = new Node(node);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(T node) {
        if (isEmpty()) {
            head = new Node(node);
            tail = head;
            return;
        }
        Node newNode = new Node(node);
        tail.next = newNode;
        tail = newNode;
    }

    public boolean isEmpty() {
        return head == null;
    }

}



