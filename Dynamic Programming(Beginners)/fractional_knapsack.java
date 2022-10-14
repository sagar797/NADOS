import java.util.Arrays;

public class fractional_knapsack {
    public static class Item implements Comparable<Item> {
        int value;
        int weight;
        double ratio;

        Item(int value, int weight, double ratio) {
            this.value = value;
            this.weight = weight;
            this.ratio = ratio;
        }

        public int compareTo(Item other) {
            if (this.ratio > other.ratio) {
                return 1;
            } else if (this.ratio < other.ratio) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        int n = 10;
        int[] items = { 33, 14, 50, 9, 8, 11, 6, 40, 2, 15 };
        int[] weight = { 7, 2, 5, 9, 3, 2, 1, 10, 3, 3 };
        int capacity = 5;

        // greedy question
        Item[] itemsArr = new Item[n];
        for (int i = 0; i < n; i++) {
            double ratio = (items[i] * 1.0) / weight[i];
            Item item = new Item(items[i], weight[i], ratio);
            itemsArr[i] = item;
        }

        Arrays.sort(itemsArr);

        double res = 0;
        for (int i = n - 1; i >= 0; i--) {
            Item item = itemsArr[i];
            if (capacity - item.weight >= 0) {
                res += item.value;
                capacity -= item.weight;
            } else {
                res += item.ratio * capacity;
                break;
            }
        }

        System.out.println(res);
    }
}
