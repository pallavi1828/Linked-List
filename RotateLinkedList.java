public class RotateLinkedList {

    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Function to rotate list
    static Node rotate(Node head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        // Count length and get tail
        Node tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Make list circular
        tail.next = head;

        // Find new tail: (length - k % length - 1)th node
        k = k % length;
        int stepsToNewTail = length - k;
        Node newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        Node newHead = newTail.next;
        newTail.next = null; // break the circle

        return newHead;
    }

    // Print list
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        int k = 3;

        System.out.println("Original List:");
        printList(head);

        head = rotate(head, k);

        System.out.println("List after rotating by " + k + " positions:");
        printList(head);
    }
}
