package linkedList;

public class Main {

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        System.out.println("========== Singly Linked List ==========\n");

        // Adding elements
        System.out.println("Adding elements...");
        list.addAtHead(30);
        list.addAtHead(20);
        list.addAtHead(10);

        list.addAtTail(40);
        list.addAtTail(50);

        System.out.print("Current List: ");
        list.printList();

        // Size
        System.out.println("\nSize: " + list.size());

        // Get element
        System.out.println("\nElement at index 2: " + list.get(2));

        // Search
        int target = 40;
        System.out.println("\nContains " + target + "? " + list.contains(target));
        System.out.println("Index of " + target + ": " + list.indexOf(target));

        // Insert
        System.out.println("\nInserting 25 at index 2...");
        list.insert(2, 25);

        System.out.print("List after insertion: ");
        list.printList();

        // Delete
        System.out.println("\nDeleting element at index 3...");
        list.delete(3);

        System.out.print("List after deletion: ");
        list.printList();

        // Delete head
        System.out.println("\nDeleting head...");
        list.deleteAtHead();

        System.out.print("List after deleting head: ");
        list.printList();

        // Final size
        System.out.println("\nFinal Size: " + list.size());

        // Exception handling demonstration
        try {
            System.out.println("\nTrying to access index 10...");
            System.out.println(list.get(10));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("\n========== Program Completed ==========");
    }
}