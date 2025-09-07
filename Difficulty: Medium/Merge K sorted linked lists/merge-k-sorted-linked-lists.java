class Solution {
    Node mergeKLists(Node[] arr) {
        if (arr == null || arr.length == 0) return null;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);

        for (Node node : arr) {
            if (node != null) pq.offer(node);
        }

        Node dummy = new Node(0);
        Node tail = dummy;

        while (!pq.isEmpty()) {
            Node minNode = pq.poll();
            tail.next = minNode;
            tail = tail.next;

            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }

        return dummy.next;
    }
}
