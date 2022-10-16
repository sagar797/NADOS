public class count_encodings {
    public static void main(String[] args) {
        String s = "123";
        // String s = "231011";
        // String s = "90";

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        if (s.charAt(0) != '0')
            dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            char firstPlace = s.charAt(i - 1);
            char secondPlace = s.charAt(i - 2);

            if (secondPlace == '0' && firstPlace == '0') {
                dp[i] = 0;
            } else if (secondPlace == '0' && firstPlace != '0') {
                dp[i] = dp[i - 1];
            } else if (secondPlace != '0' && firstPlace == '0') {
                if (secondPlace <= '2')
                    dp[i] = dp[i - 2];
            } else if (secondPlace != '0' && firstPlace != '0') {
                dp[i] += dp[i - 1];
                if (secondPlace < '2' || (secondPlace == '2' && firstPlace <= '6')) {
                    dp[i] += dp[i - 2];
                }
            }
        }

        for (int val : dp)
            System.out.print(val + " ");
        System.out.println();

        System.out.println(dp[s.length()]);
    }
}
