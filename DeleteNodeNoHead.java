public class DeleteNodeNoHead {

    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Delete given node (not last node)
    static void deleteNode(Node node) {
        if (node == null || node.next == null) {
            System.out.println("Cannot delete the last node or null node!");
            return;
        }

        node.data = node.next.data;
        node.next = node.next.next;
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
        // Create list: 10 → 20 → 30 → 40 → 50
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        System.out.println("Original list:");
        printList(head);

        // Suppose we are given access to node with value 30
        Node nodeToDelete = head.next.next;

        // Delete it
        deleteNode(nodeToDelete);

        System.out.println("After deleting node with value 30:");
        printList(head);
    }
}
