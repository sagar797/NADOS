public class combinations_2 {
    public static void main(String[] args) {
        int n = 5;
        int k = 3;

        combinations_2_sol(-1, new int[n], k);
    }

    private static void combinations_2_sol(int lastElement, int[] pos, int k) {
        if (k == 0) {
            for (int val : pos) {
                if (val == 0)
                    System.out.print("-");
                else
                    System.out.print("i");
            }

            System.out.println();
            return;
        }

        for (int i = lastElement + 1; i < pos.length; i++) {
            if (pos[i] == 0) {
                pos[i] = 1;
                combinations_2_sol(i, pos, k - 1);
                pos[i] = 0;
            }
        }
    }
}
