//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

class ReverseInSize {
    static Node head;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());

        while (t-- > 0) {

            String s[] = in.readLine().trim().split(" ");
            int a1 = Integer.parseInt(s[0]);
            Node head = new Node(a1);
            Node tail = head;
            for (int i = 1; i < s.length; i++) {
                int a = Integer.parseInt(s[i]);
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail = tail.next;
            }

            int k = Integer.parseInt(in.readLine().trim());
            Solution ob = new Solution();
            Node res = ob.reverseKGroup(head, k);
            printList(res, out);
            out.println();

            out.println("~");
        }
        out.close();
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
    }
}

// } Driver Code Ends


/*node class of the linked list
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution {
 public Node reverseKGroup(Node head, int k) {
        if (head == null) return null; // If the list is empty, return null

        Node prev = null;      // Initialize previous pointer for reversal
        Node curr = head;      // Start with the head of the list
        Node nextNode = null;  // Pointer to store the next node
        int count = 0;         // Counter to track the number of nodes reversed

        // Reverse `k` nodes in the group
        while (curr != null && count < k) {
            nextNode = curr.next; // Store the next node
            curr.next = prev;     // Reverse the current node's pointer
            prev = curr;          // Move the previous pointer forward
            curr = nextNode;      // Move the current pointer forward
            count++;              // Increment the counter
        }

        // Recursive call to process the remaining nodes
        if (nextNode != null) {
            head.next = reverseKGroup(nextNode, k); // Connect the end of the reversed group to the next reversed group
        }

        return prev; // Return the new head of the reversed group
    }
}
