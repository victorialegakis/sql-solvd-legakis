package hometask.agency.generics;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    public T getHead() {
        return head.node;
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

    public void print() {
        Logger LOG_LINKED = LogManager.getLogger(CustomLinkedList.class.getName());
        Node current = head;
        while (current != null) {
            LOG_LINKED.info(current.node);
            current = current.next;
        }
    }

    public T insert(int pos, T node) {
        if (pos == 1) {
            addFirst(node);
            return null;
        }
        Node current = head;
        int count = 1;
        while (count < (pos - 1)) {
            count++;
            current = current.next;
        }
        Node newNode = new Node(node);
        newNode.next = current.next;
        current.next = newNode;
        return null;
    }

    public boolean search(T node) {
        boolean isFound = false;
        Node current = head;
        while (current != null & !isFound) {
            if (node == current.node) {
                isFound = true;
            }
            current = current.next;
        }
        return isFound;
    }

    public boolean isEmpty() {
        return head == null;
    }


}



