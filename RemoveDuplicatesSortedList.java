public class RemoveDuplicatesSortedList {

    // Node class
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    // Add node to end
    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
    }

    // Display the linked list
    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    // Remove duplicates from sorted list
    public void removeDuplicates() {
        Node current = head;

        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next; // skip duplicate
            } else {
                current = current.next;
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        RemoveDuplicatesSortedList list = new RemoveDuplicatesSortedList();

        // Add sorted elements with duplicates
        list.add(10);
        list.add(20);
        list.add(20);
        list.add(30);
        list.add(30);
        list.add(30);
        list.add(40);

        System.out.println("Original List:");
        list.display();

        list.removeDuplicates();

        System.out.println("List after removing duplicates:");
        list.display();
    }
}
