public class coin_change_permutations_1 {
    public static void main(String[] args) {
        int[] coins = { 2, 3, 5, 6, 7 };
        int amt = 12;

        boolean[] usedCoins = new boolean[coins.length];

        solution(coins, amt, usedCoins, "");
    }

    private static void solution(int[] coins, int amt, boolean[] usedCoins, String asf) {
        if (amt == 0) {
            System.out.println(asf + ".");
            return;
        }

        for (int i = 0; i < coins.length; i++) {
            if (!usedCoins[i] && amt - coins[i] >= 0) {
                usedCoins[i] = true;
                solution(coins, amt - coins[i], usedCoins, asf + coins[i] + "-");
                usedCoins[i] = false;
            }
        }
    }
}
