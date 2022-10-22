public class paint_house_many_colors {
    public static void main(String[] args) {
        int houses = 4;
        int paints = 3;
        int[][] paintCost = {
                { 1, 5, 7 },
                { 5, 8, 4 },
                { 3, 2, 9 },
                { 1, 2, 4 }
        };

        int[][] dp = new int[houses][paints];
        int res = Integer.MAX_VALUE;

        int previousMin = Integer.MAX_VALUE;
        int previousSecondMin = Integer.MAX_VALUE;
        for (int i = 0; i < houses; i++) {
            int currentMin = Integer.MAX_VALUE;
            int currentSecondMin = Integer.MAX_VALUE;

            for (int j = 0; j < paints; j++) {
                if (i == 0) {
                    dp[i][j] = paintCost[i][j];
                } else {
                    if (previousMin == dp[i - 1][j]) {
                        dp[i][j] = previousSecondMin + paintCost[i][j];
                    } else {
                        dp[i][j] = previousMin + paintCost[i][j];
                    }
                }

                if (i == houses - 1 && dp[i][j] < res) {
                    res = dp[i][j];
                }

                if (dp[i][j] < currentMin) {
                    currentSecondMin = currentMin;
                    currentMin = dp[i][j];
                } else if (dp[i][j] < currentSecondMin) {
                    currentSecondMin = dp[i][j];
                }
            }

            previousMin = currentMin;
            previousSecondMin = currentSecondMin;
        }

        System.out.println(res);
    }
}
