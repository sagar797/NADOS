public class buy_and_sell_stock_one_transaction_allowed {
    public static void main(String[] args) {
        int n = 9;
        int[] arr = { 11, 6, 7, 19, 4, 1, 6, 18, 4 };

        int buy = arr[0];
        int profit = 0;

        for (int i = 1; i < n; i++) {
            profit = Math.max(profit, arr[i] - buy);
            buy = Math.min(buy, arr[i]);
        }

        System.out.println(profit);
    }
}
