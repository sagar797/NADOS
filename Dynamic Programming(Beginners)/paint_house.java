public class paint_house {
    public static void main(String[] args) {
        int houses = 4;
        int[][] paintCost = {
                { 1, 5, 7 },
                { 5, 8, 4 },
                { 3, 2, 9 },
                { 1, 2, 4 }
        };

        int[][] dp = new int[houses][3];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0) {
                    dp[i][j] = paintCost[i][j];
                } else if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j + 1], dp[i - 1][j + 2]) + paintCost[i][j];
                } else if (j == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]) + paintCost[i][j];
                } else if (j == 2) {
                    dp[i][j] = Math.min(dp[i - 1][j - 2], dp[i - 1][j - 1]) + paintCost[i][j];
                }
            }
        }

        System.out.println(Math.min(dp[houses - 1][0], Math.min(dp[houses - 1][1], dp[houses - 1][2])));
    }
}
