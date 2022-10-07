public class path_with_maximum_gold {
    public static void main(String[] args) {
        int[][] mine = {
                { 0, 6, 0 },
                { 5, 8, 7 },
                { 0, 9, 0 }
        };

        // int[][] mine = {
        // { 1, 0, 7 },
        // { 2, 0, 6 },
        // { 3, 4, 5 },
        // { 0, 3, 0 },
        // { 9, 0, 20 }
        // };

        int[][] pos = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

        int maxSum = 0;

        for (int i = 0; i < mine.length; i++) {
            for (int j = 0; j < mine[i].length; j++) {
                int sum = solution(i * mine[i].length + j, mine, pos);
                if (sum > maxSum)
                    maxSum = sum;
            }
        }

        System.out.println(maxSum);
    }

    private static int solution(int idx, int[][] mine, int[][] pos) {
        if (idx > mine.length * mine[0].length) {
            return 0;
        }

        int r = idx / mine[0].length;
        int c = idx % mine[0].length;

        int sum = 0;
        for (int i = 0; i < pos.length; i++) {
            int nr = r + pos[i][0];
            int nc = c + pos[i][1];

            if (nr >= 0 && nr < mine.length && nc >= 0 && nc < mine[0].length && mine[nr][nc] != 0) {
                int temp = mine[r][c];
                mine[r][c] = 0;
                sum = Math.max(sum, solution(nr * mine[0].length + nc, mine, pos));
                mine[r][c] = temp;
            }
        }

        return sum + mine[r][c];
    }
}
