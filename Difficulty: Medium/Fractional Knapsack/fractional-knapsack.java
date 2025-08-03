class Solution {

    static class Item {
        int value, weight;
        double ratio;

        Item(int val, int wt) {
            this.value = val;
            this.weight = wt;
            this.ratio = (double) val / wt;
        }
    }

    double fractionalKnapsack(int[] values, int[] weights, int W) {
        int n = values.length;
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(values[i], weights[i]);
        }

        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                if (b.ratio > a.ratio) {
                    return 1;
                } else if (b.ratio < a.ratio) {
                    return -1;
                }
                return 0;
            }
        });

        double totalValue = 0.0;
        double remainingCapacity = (double) W;

        for (int i = 0; i < n && remainingCapacity > 0; i++) {
            if (items[i].weight <= remainingCapacity) {
                totalValue += items[i].value;
                remainingCapacity -= items[i].weight;
            } else {
                double fraction = remainingCapacity / items[i].weight;
                totalValue += fraction * items[i].value;
                remainingCapacity = 0;
            }
        }

        return totalValue;
    }
}