public class combinations_1 {
    public static void main(String[] args) {
        int n = 5;
        int k = 3;

        getCombinations(n, k, "");
    }

    private static void getCombinations(int n, int k, String asf) {
        if (n == 0) {
            if (k == 0)
                System.out.println(asf);
            return;
        }

        getCombinations(n - 1, k - 1, asf + "i");
        getCombinations(n - 1, k, asf + "-");
    }
}