class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        boolean leftToRight = true;  
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                level.add(current.data);

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

            if (!leftToRight) {
                Collections.reverse(level);
            }

            result.addAll(level);

            leftToRight = !leftToRight;
        }

        return result;
    }
}