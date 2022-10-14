public class count_binary_strings {
    public static void main(String[] args) {
        int n = 6;

        int[] startingFromZeros = new int[n];
        int[] startingFromOnes = new int[n];

        startingFromOnes[0] = startingFromZeros[0] = 1;
        for (int i = 1; i < n; i++) {
            startingFromZeros[i] += startingFromOnes[i - 1];
            startingFromOnes[i] += startingFromOnes[i - 1] + startingFromZeros[i - 1];
        }

        System.out.println(startingFromOnes[n - 1] + startingFromZeros[n - 1]);
    }
}
