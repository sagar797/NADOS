public class partition_into_subsets {
    public static void main(String[] args) {
        int n = 4;
        int k = 3;

        System.out.println(recursionApproach(n, k));
        dpApproach(n, k);
    }

    private static int recursionApproach(int n, int k) {
        if (n == 0 || n < k)
            return 0;

        if (n == k || k == 1)
            return 1;

        int getKPartitionCount = recursionApproach(n - 1, k);
        int getKMinus1PartitionCount = recursionApproach(n - 1, k - 1);

        return getKPartitionCount * k + getKMinus1PartitionCount;
    }

    public static void dpApproach(int n, int k) {
        int[][] dp = new int[k + 1][n + 1];

        for (int partition = 1; partition <= k; partition++) {
            for (int elem = 1; elem <= n; elem++) {
                if (partition == 1) {
                    dp[partition][elem] = 1;
                } else if (partition > elem) {
                    dp[partition][elem] = 0;
                } else if (partition == elem) {
                    dp[partition][elem] = 1;
                } else {
                    dp[partition][elem] = dp[partition][elem - 1] * partition + dp[partition - 1][elem - 1];
                }
            }
        }

        System.out.println(dp[k][n]);
    }
}
