import java.util.*;

class Solution {
    long[] segTree;
    int n;

    public ArrayList<Long> RangeLCMQuery(int[] arr, int[][] queries) {
        n = arr.length;
        segTree = new long[4 * n];

        build(0, 0, n - 1, arr);

        ArrayList<Long> res = new ArrayList<>();

        for (int[] q : queries) {
            if (q[0] == 1) {
                update(0, 0, n - 1, q[1], q[2]);
            } else {
                res.add(query(0, 0, n - 1, q[1], q[2]));
            }
        }

        return res;
    }

    void build(int idx, int l, int r, int[] arr) {
        if (l == r) {
            segTree[idx] = arr[l];
            return;
        }

        int mid = (l + r) / 2;

        build(2 * idx + 1, l, mid, arr);
        build(2 * idx + 2, mid + 1, r, arr);

        segTree[idx] = lcm(segTree[2 * idx + 1], segTree[2 * idx + 2]);
    }

    void update(int idx, int l, int r, int pos, int val) {
        if (l == r) {
            segTree[idx] = val;
            return;
        }

        int mid = (l + r) / 2;

        if (pos <= mid) {
            update(2 * idx + 1, l, mid, pos, val);
        } else {
            update(2 * idx + 2, mid + 1, r, pos, val);
        }

        segTree[idx] = lcm(segTree[2 * idx + 1], segTree[2 * idx + 2]);
    }

    long query(int idx, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return segTree[idx];
        }

        if (r < ql || l > qr) {
            return 1;
        }

        int mid = (l + r) / 2;

        long left = query(2 * idx + 1, l, mid, ql, qr);
        long right = query(2 * idx + 2, mid + 1, r, ql, qr);

        return lcm(left, right);
    }

    long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}