package linkedList;

public class SinglyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    public int size() {
        return size;
    }

    public int indexOf(int value) {
        if (head == null) return -1;

        Node current = head;
        int index = 0;

        while (current != null) {
            if (current.val == value)
                return index;

            current = current.next;
            index++;
        }

        return -1;
    }

    public boolean contains(int value) {
        if (head == null)
            return false;

        Node current = head;

        while (current != null) {
            if (current.val == value)
                return true;

            current = current.next;
        }

        return false;
    }

    public int get(int index) {

        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index.");

        Node current = head;

        for (int i = 0; i < index; i++)
            current = current.next;

        return current.val;
    }

    /**
     * Inserts a new node at the specified index.
     *
     * @param index position where node will be inserted
     * @param value value to insert
     * @throws IndexOutOfBoundsException if index is invalid
     */

    public void insert(int index, int value) {

        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Invalid index.");

        if (index == 0) {
            addAtHead(value);
        }

        else if (index == size) {
            addAtTail(value);
        }

        else {

            Node current = head;

            for (int i = 0; i < index - 1; i++)
                current = current.next;

            Node newNode = new Node(value);

            newNode.next = current.next;
            current.next = newNode;

            size++;
        }
    }

    public void deleteAtHead() {

        if (head == null)
            throw new IndexOutOfBoundsException("Linked list is empty.");

        if (head == tail) {
            head = tail = null;
        }

        else {
            head = head.next;
        }

        size--;
    }

    public void addAtHead(int value) {

        Node newNode = new Node(value);

        if (head == null) {
            head = tail = newNode;
        }

        else {
            newNode.next = head;
            head = newNode;
        }

        size++;
    }

    public void addAtTail(int value) {

        Node newNode = new Node(value);

        if (tail == null) {
            head = tail = newNode;
        }

        else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
    }

    public void printList() {

        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }

        Node current = head;

        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }

        System.out.println();
    }

    public void delete(int index) {

        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index.");

        if (index == 0) {
            deleteAtHead();
            return;
        }

        Node current = head;

        for (int i = 1; i < index; i++)
            current = current.next;

        current.next = current.next.next;

        if (index == size - 1)
            tail = current;

        size--;
    }
}