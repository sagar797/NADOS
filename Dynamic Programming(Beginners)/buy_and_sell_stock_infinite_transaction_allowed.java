public class buy_and_sell_stock_infinite_transaction_allowed {
    public static void main(String[] args) {
        // int n = 9;
        // int[] arr = { 11, 6, 7, 19, 4, 1, 6, 18, 4 };

        int n = 8;
        int[] arr = { 5, 2, 0, 2, 1, 2, 0, 7 };

        int idx = 0;
        int profit = 0;

        while (idx < n) {
            // go to smallest consecutive number i.e buy price
            while (idx + 1 < n && arr[idx + 1] < arr[idx]) {
                idx++;
            }
            int buy = arr[idx];

            // go to highest consecutive peak i.e sell price
            while (idx + 1 < n && arr[idx + 1] > arr[idx]) {
                idx++;
            }
            int sell = arr[idx];
            profit += sell - buy;

            idx++;
        }

        System.out.println(profit);
    }
}
