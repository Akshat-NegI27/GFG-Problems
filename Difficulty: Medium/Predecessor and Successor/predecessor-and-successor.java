//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Gfg {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            int key = Integer.parseInt(br.readLine());

            Solution sol = new Solution();
            ArrayList<Node> result = sol.findPreSuc(root, key);
            Node pre = result.get(0);
            Node suc = result.get(1);

            if (pre != null)
                System.out.print(pre.data + " ");
            else
                System.out.print("-1 ");

            if (suc != null)
                System.out.println(suc.data);
            else
                System.out.println("-1");
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/* BST Node
class Node {
    int data;
    Node left, right;
    Node(int x) {
        data = x;
        left = right = null;
    }
} */

class Solution {
    Node pre = null, suc = null;

    public ArrayList<Node> findPreSuc(Node root, int key) {
        findPreSucHelper(root, key);
        ArrayList<Node> result = new ArrayList<>();
        result.add(pre != null ? pre : new Node(-1));  
        result.add(suc != null ? suc : new Node(-1));  
        return result;
    }

    private void findPreSucHelper(Node root, int key) {
        if (root == null) return;

        if (root.data == key) {

            if (root.left != null) {
                Node temp = root.left;
                while (temp.right != null) temp = temp.right;
                pre = temp;
            }

            if (root.right != null) {
                Node temp = root.right;
                while (temp.left != null) temp = temp.left;
                suc = temp;
            }
        }
        else if (key < root.data) {
            suc = root;
            findPreSucHelper(root.left, key);
        }
        else {
            pre = root;
            findPreSucHelper(root.right, key);
        }
    }
}