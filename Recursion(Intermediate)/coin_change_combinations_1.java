public class coin_change_combinations_1 {
    public static void main(String[] args) {
        int[] coins = { 2, 3, 5, 6, 7 };
        int amount = 12;

        solution(0, coins, amount, "");
    }

    private static void solution(int idx, int[] coins, int amount, String asf) {
        if (amount < 0)
            return;
        if (idx == coins.length) {
            if (amount == 0)
                System.out.println(asf + ".");
            return;
        }

        // include the coin
        solution(idx + 1, coins, amount - coins[idx], asf + coins[idx] + "-");

        // doesn't include the coin
        solution(idx + 1, coins, amount, asf);
    }
}
