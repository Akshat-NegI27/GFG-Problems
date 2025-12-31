class Solution {
    public boolean isPalindrome(Node head) {
        if (head == null || head.next == null)
            return true;

        Node slow = head, fast = head;

        // Find middle
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node second = reverse(slow.next);

        // Compare both halves
        Node first = head;
        Node temp = second;
        boolean isPal = true;

        while (temp != null) {
            if (first.data != temp.data) {
                isPal = false;
                break;
            }
            first = first.next;
            temp = temp.next;
        }

        // Optional: restore list
        slow.next = reverse(second);

        return isPal;
    }

    private Node reverse(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
