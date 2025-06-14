public class DetectAndRemoveLoop {

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

    // Add a node at the end
    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Display the list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Detect and remove loop
    public void detectAndRemoveLoop() {
        Node slow = head;
        Node fast = head;
        boolean loopExists = false;

        // Step 1: Detect loop using Floyd’s algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                loopExists = true;
                break;
            }
        }

        if (!loopExists) {
            System.out.println("No loop detected.");
            return;
        }

        // Step 2: Find the start of the loop
        slow = head;
        Node prev = null; // To keep track of node before loop start
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // Step 3: Remove loop
        prev.next = null;

        System.out.println("Loop detected and removed at node with data: " + slow.data);
    }

    // Create a loop for testing (last node points to node at given position)
    public void createLoop(int pos) {
        if (pos == 0) return;

        Node loopNode = head;
        for (int i = 1; i < pos && loopNode != null; i++) {
            loopNode = loopNode.next;
        }

        Node end = head;
        while (end.next != null) {
            end = end.next;
        }

        end.next = loopNode; // Create loop
    }

    // Main method
    public static void main(String[] args) {
        DetectAndRemoveLoop list = new DetectAndRemoveLoop();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.createLoop(3); // Creates loop: 5 -> 3

        list.detectAndRemoveLoop();

        System.out.println("Linked list after loop removal:");
        list.display();
    }
}
