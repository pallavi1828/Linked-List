public class RemoveLoopInLinkedList {

    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Detect and remove loop
    static void detectAndRemoveLoop(Node head) {
        Node slow = head;
        Node fast = head;

        // Step 1: Detect loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Loop detected
                removeLoop(head, slow);
                System.out.println("Loop removed");
                return;
            }
        }

        System.out.println("No loop found");
    }

    // Step 2: Remove loop
    static void removeLoop(Node head, Node loopNode) {
        Node ptr1 = head;
        Node ptr2 = loopNode;

        // Move both one step at a time until next pointers match
        while (ptr1.next != ptr2.next) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        // Break the loop
        ptr2.next = null;
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

    public static void main(String[] args) {
        // Creating nodes
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Create loop: 5 → 3
        head.next.next.next.next.next = head.next.next;

        detectAndRemoveLoop(head);

        System.out.println("List after loop removal:");
        printList(head);
    }
}
