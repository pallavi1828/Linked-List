public class PalindromeLinkedList {

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

    // Display the list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Reverse a list and return new head
    private Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Check if palindrome
    public boolean isPalindrome() {
        if (head == null || head.next == null)
            return true;

        Node slow = head, fast = head;

        // Step 1: Find middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        Node secondHalf = reverse(slow);
        Node firstHalf = head;

        // Step 3: Compare both halves
        Node temp = secondHalf;
        while (temp != null) {
            if (firstHalf.data != temp.data)
                return false;
            firstHalf = firstHalf.next;
            temp = temp.next;
        }

        return true;
    }

    // Main method
    public static void main(String[] args) {
        PalindromeLinkedList list = new PalindromeLinkedList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(1);

        System.out.println("Linked List:");
        list.display();

        if (list.isPalindrome())
            System.out.println("The list is a palindrome.");
        else
            System.out.println("The list is not a palindrome.");
    }
}
