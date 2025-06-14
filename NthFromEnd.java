public class NthFromEnd {

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

    // Add node to end of the list
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

    // Display the list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Find Nth node from the end
    public void findNthFromEnd(int n) {
        Node first = head;
        Node second = head;

        // Move first pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (first == null) {
                System.out.println("List has fewer than " + n + " nodes.");
                return;
            }
            first = first.next;
        }

        // Move both pointers until first reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        System.out.println("The " + n + "th node from the end is: " + second.data);
    }

    // Main method
    public static void main(String[] args) {
        NthFromEnd list = new NthFromEnd();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        System.out.println("Linked List:");
        list.display();

        list.findNthFromEnd(2);  // Example: 2nd node from end should be 40
    }
}
