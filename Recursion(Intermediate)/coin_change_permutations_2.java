public class coin_change_permutations_2 {
    public static void main(String[] args) {
        int[] coins = { 2, 3, 5 };
        int amt = 7;

        solution(coins, amt, "");
    }

    private static void solution(int[] coins, int amt, String asf) {
        if (amt == 0) {
            System.out.println(asf + ".");
            return;
        }

        for (int i = 0; i < coins.length; i++) {
            if (amt - coins[i] >= 0) {
                solution(coins, amt - coins[i], asf + coins[i] + "-");
            }
        }
    }
}