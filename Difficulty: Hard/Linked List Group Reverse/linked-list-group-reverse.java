class Solution {
    public Node reverseKGroup(Node head, int k) {
        if (head == null || k == 1) return head;

        Node dummy = new Node(0);
        dummy.next = head;

        Node prevGroupEnd = dummy;
        Node curr = head;

        while (curr != null) {

            Node check = curr;
            int count = 0;
            while (count < k && check != null) {
                check = check.next;
                count++;
            }

            if (count < k && curr == null) break;

            Node prev = null;
            Node tempHead = curr;
            for (int i = 0; i < count; i++) {
                Node nextNode = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextNode;
            }

            prevGroupEnd.next = prev;
            tempHead.next = curr;
            prevGroupEnd = tempHead;
        }

        return dummy.next;
    }
}