public class MergeTwoSortedLists {

    // Node class
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to print the list
    public void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Merge two sorted linked lists
    public Node merge(Node a, Node b) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (a != null && b != null) {
            if (a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        // Attach the rest
        if (a != null) tail.next = a;
        if (b != null) tail.next = b;

        return dummy.next;
    }

    // Main method
    public static void main(String[] args) {
        MergeTwoSortedLists obj = new MergeTwoSortedLists();

        // First sorted list: 10 -> 20 -> 30
        Node a1 = obj.new Node(10);
        Node a2 = obj.new Node(20);
        Node a3 = obj.new Node(30);
        a1.next = a2;
        a2.next = a3;

        // Second sorted list: 15 -> 25 -> 35
        Node b1 = obj.new Node(15);
        Node b2 = obj.new Node(25);
        Node b3 = obj.new Node(35);
        b1.next = b2;
        b2.next = b3;

        System.out.println("List 1:");
        obj.display(a1);

        System.out.println("List 2:");
        obj.display(b1);

        Node merged = obj.merge(a1, b1);

        System.out.println("Merged List:");
        obj.display(merged);
    }
}
