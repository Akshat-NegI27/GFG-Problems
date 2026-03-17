import java.util.*;

class Solution {
    public int minTime(Node root, int target) {
        HashMap<Node, Node> parent = new HashMap<>();
        Node targetNode = markParents(root, parent, target);

        Queue<Node> q = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();

        q.add(targetNode);
        visited.add(targetNode);

        int time = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            time++;

            for (int i = 0; i < size; i++) {
                Node node = q.poll();

                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    q.add(node.left);
                }

                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    q.add(node.right);
                }

                if (parent.containsKey(node) && !visited.contains(parent.get(node))) {
                    visited.add(parent.get(node));
                    q.add(parent.get(node));
                }
            }
        }

        return time;
    }

    Node markParents(Node root, HashMap<Node, Node> parent, int target) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node targetNode = null;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node.data == target) {
                targetNode = node;
            }

            if (node.left != null) {
                parent.put(node.left, node);
                q.add(node.left);
            }

            if (node.right != null) {
                parent.put(node.right, node);
                q.add(node.right);
            }
        }

        return targetNode;
    }
}