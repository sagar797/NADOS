public class max_sum_non_adjacent_elements {
    public static void main(String[] args) {
        int n = 7;
        int[] arr = { 5, 10, 10, 100, 5, 6, 8 };

        int include = arr[0];
        int exclude = 0;

        for (int i = 1; i < n; i++) {
            int newInclude = exclude + arr[i];
            int newExclude = Math.max(include, exclude);
            include = newInclude;
            exclude = newExclude;
        }

        System.out.println(Math.max(include, exclude));
    }
}
