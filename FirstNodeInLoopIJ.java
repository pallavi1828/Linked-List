public class FirstNodeInLoopIJ {

    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Find the first node where loop starts
    static Node findFirstNodeInLoop(Node head) {
        Node i = head; // like slow
        Node j = head; // like fast

        // Step 1: Detect loop
        while (j != null && j.next != null) {
            i = i.next;
            j = j.next.next;

            if (i == j) {
                break; // Loop detected
            }
        }

        // No loop found
        if (j == null || j.next == null) {
            return null;
        }

        // Step 2: Move i to head, keep j at meeting point
        i = head;
        while (i != j) {
            i = i.next;
            j = j.next;
        }

        // i (or j) is now the starting point of the loop
        return i;
    }

    public static void main(String[] args) {
        // Create: 1 → 2 → 3 → 4 → 5 → back to 3 (loop)
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head.next.next; // loop at 3

        Node loopStart = findFirstNodeInLoop(head);

        if (loopStart != null) {
            System.out.println("Loop starts at node with data: " + loopStart.data);
        } else {
            System.out.println("No loop found.");
        }
    }
}
