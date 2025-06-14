public class IdenticalLinkedLists {

    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Function to check if two lists are identical
    static boolean areIdentical(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if (head1.data != head2.data) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        // If both reached end, they are identical
        return head1 == null && head2 == null;
    }

    // Print a linked list
    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // First list: 10 -> 20 -> 30
        Node head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = new Node(30);

        // Second list: 10 -> 20 -> 30
        Node head2 = new Node(10);
        head2.next = new Node(20);
        head2.next.next = new Node(30);

        // Check if identical
        if (areIdentical(head1, head2)) {
            System.out.println("The linked lists are identical.");
        } else {
            System.out.println("The linked lists are not identical.");
        }
    }
}
