public class permutations_1 {
    public static void main(String[] args) {
        int n = 5;
        int k = 3;
        int[] pos = new int[n];

        permutations_1_sol(1, k, pos);
    }

    private static void permutations_1_sol(int idx, int k, int[] pos) {
        if (idx > k) {
            for (int val : pos)
                System.out.print(val);
            System.out.println();
            return;
        }

        for (int i = 0; i < pos.length; i++) {
            if (pos[i] == 0) {
                pos[i] = idx;
                permutations_1_sol(idx + 1, k, pos);
                pos[i] = 0;
            }
        }
    }
}
