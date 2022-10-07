public class climb_staris_with_variable_jumps {
    public static void main(String[] args) {
        int n = 10;
        int[] arr = { 3, 3, 0, 2, 1, 2, 4, 2, 0, 0 };

        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            int jumps = arr[i];
            for (int j = 1; j <= jumps && i + j < dp.length; j++) {
                dp[i] += dp[i + j];
            }
        }

        System.out.println(dp[0]);
    }
}
