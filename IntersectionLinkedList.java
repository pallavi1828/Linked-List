public class IntersectionLinkedList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Count nodes in a list
    int getLength(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    // Find intersection point
    Node getIntersection(Node head1, Node head2) {
        int len1 = getLength(head1);
        int len2 = getLength(head2);

        // Move longer list ahead by the difference
        int diff = Math.abs(len1 - len2);

        if (len1 > len2) {
            for (int i = 0; i < diff; i++) {
                head1 = head1.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                head2 = head2.next;
            }
        }

        // Move both together until they meet
        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1; // intersection point
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return null; // no intersection
    }

    public static void main(String[] args) {
        IntersectionLinkedList obj = new IntersectionLinkedList();

        // List 1: 10 -> 20 -> 30 \
        //                          -> 40 -> 50
        // List 2:         15 ----/

        // Shared part
        Node common1 = obj.new Node(40);
        Node common2 = obj.new Node(50);
        common1.next = common2;

        // First list
        Node a1 = obj.new Node(10);
        Node a2 = obj.new Node(20);
        Node a3 = obj.new Node(30);
        a1.next = a2;
        a2.next = a3;
        a3.next = common1;

        // Second list
        Node b1 = obj.new Node(15);
        b1.next = common1;

        // Find intersection
        Node intersection = obj.getIntersection(a1, b1);

        if (intersection != null) {
            System.out.println("Intersection at node with data: " + intersection.data);
        } else {
            System.out.println("No intersection found.");
        }
    }
}
