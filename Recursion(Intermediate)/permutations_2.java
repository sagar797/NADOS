public class permutations_2 {
    public static void main(String[] args) {
        // int n = 5;
        // int k = 3;
        int n = 3;
        int k = 2;
        int[] items = new int[k + 1];

        permutations_2_sol(0, n, k, items, "");
    }

    private static void permutations_2_sol(int idx, int n, int k, int[] items, String asf) {
        if (idx == n) {
            if (k == 0) {
                System.out.println(asf);
            }
            return;
        }

        for (int i = 1; i < items.length; i++) {
            if (items[i] == 0) {
                items[i] = 1;
                permutations_2_sol(idx + 1, n, k - 1, items, asf + i);
                items[i] = 0;
            }
        }

        permutations_2_sol(idx + 1, n, k, items, asf + "0");
    }
}
