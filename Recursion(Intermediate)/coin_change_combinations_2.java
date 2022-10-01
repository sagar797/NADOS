public class coin_change_combinations_2 {
    public static void main(String[] args) {
        int[] coins = { 2, 3, 5, 6, 7 };
        int amount = 12;

        solution(0, coins, amount, "");
    }

    private static void solution(int idx, int[] coins, int amount, String asf) {
        if (amount < 0)
            return;

        if (amount == 0) {
            System.out.println(asf + ".");
            return;
        }

        for (int i = idx; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                solution(i, coins, amount - coins[i], asf + coins[i] + "-");
            }
        }
    }
}
