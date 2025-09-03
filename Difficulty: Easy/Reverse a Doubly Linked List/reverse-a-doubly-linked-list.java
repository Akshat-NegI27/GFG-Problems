/*
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/

class Solution {
    public Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head; // empty or single-node list
        }
        
        Node current = head;
        Node temp = null;
        
        // Traverse the list
        while (current != null) {
            // Swap next and prev
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            
            // Move to the next node (which is prev now)
            current = current.prev;
        }
        
        // After loop, temp is at the old head's prev
        // So new head is temp.prev
        if (temp != null) {
            head = temp.prev;
        }
        
        return head;
    }
}
