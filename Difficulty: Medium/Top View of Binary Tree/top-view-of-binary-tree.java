class Solution {
    public ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node node = p.node;
            int hd = p.hd;

            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }

            if (node.left != null) q.add(new Pair(node.left, hd - 1));
            if (node.right != null) q.add(new Pair(node.right, hd + 1));
        }

        for (int val : map.values()) {
            res.add(val);
        }

        return res;
    }
}

class Pair {
    Node node;
    int hd;

    Pair(Node n, int h) {
        node = n;
        hd = h;
    }
}