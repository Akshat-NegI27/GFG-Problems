class Solution {
    Node compute(Node head) {
        head = reverse(head);

        int maxSoFar = head.data;
        Node curr = head;

        while (curr != null && curr.next != null) {
            if (curr.next.data < maxSoFar) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
                maxSoFar = curr.data;
            }
        }

        return reverse(head);
    }

    private Node reverse(Node head) {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}