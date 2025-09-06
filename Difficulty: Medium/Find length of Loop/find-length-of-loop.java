/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int lengthOfLoop(Node head) {
        if (head == null) return 0;

        Node slow = head, fast = head;

        // Step 1: Detect loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Loop found -> Step 2: count length
                return countLoopLength(slow);
            }
        }
        return 0; // No loop
    }

    private int countLoopLength(Node nodeInLoop) {
        int count = 1;
        Node current = nodeInLoop.next;
        
        while (current != nodeInLoop) {
            count++;
            current = current.next;
        }
        return count;
    }
}
