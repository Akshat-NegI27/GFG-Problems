/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node segregate(Node head) {
        if (head == null || head.next == null) return head;

        // Dummy heads for 0, 1, and 2 lists
        Node zeroD = new Node(-1), oneD = new Node(-1), twoD = new Node(-1);
        Node zero = zeroD, one = oneD, two = twoD;

        // Traverse the list and link nodes into respective lists
        Node curr = head;
        while (curr != null) {
            if (curr.data == 0) {
                zero.next = curr;
                zero = zero.next;
            } else if (curr.data == 1) {
                one.next = curr;
                one = one.next;
            } else {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }

        // Connect three lists: 0 -> 1 -> 2
        zero.next = (oneD.next != null) ? oneD.next : twoD.next;
        one.next = twoD.next;
        two.next = null; // end of list

        // Head is first non-empty list
        return zeroD.next != null ? zeroD.next : (oneD.next != null ? oneD.next : twoD.next);
    }
}
