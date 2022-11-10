public class tiling_with_mX1_tiles {
    public static void main(String[] args) {
        // int m = 16;
        // int n = 15;

        int m = 16;
        int n = 39;

        int[] dp = new int[n + 1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            // put tile horizontally
            dp[i] = dp[i - 1];

            // put tile vertically
            if (i - m == 0) {
                // if same length and breadth
                dp[i] += 1;
            } else if (i - m > 0) {
                // if some breadth is left after putting a tile vertically
                dp[i] += dp[i - m];
            }
        }

        System.out.println(dp[n]);
    }
}
