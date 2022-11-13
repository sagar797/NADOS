public class buy_and_sell_stock_with_transaction_fee__infinite_transaction_allowed {
    public static void main(String[] args) {
        // If thinking why modifying logic in prev ques(adding fee to it) wont work,

        // Its wrong!
        // Take an example [ 1,3,7,5,10,3], Fee=3
        // According previous questions' modified logic, it will
        // Buy at 1, sell at 7, then buy at 5 and sell at 10. Transactions=2
        // (subtracting fees for count of transactions while calculating total profit)
        // Total Profit = (7-1-3) + (10-5-3) = 5

        // But Correct Answer is ->
        // Buy at 1, Sell at 10. Transactions = 1
        // Total Profit = 10-1-3 = 6

        int n = 12;
        int[] arr = { 10, 15, 17, 20, 16, 18, 22, 20, 22, 20, 23, 25 };
        int fee = 3;

        int[][] dp = new int[n][2];
        dp[0][0] = -arr[0]; // buy state
        dp[0][1] = 0; // sell state

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - arr[i]);
            dp[i][1] = Math.max(dp[i - 1][1], arr[i] + dp[i - 1][0] - fee);
        }

        System.out.println(dp[n - 1][1]);
    }
}
