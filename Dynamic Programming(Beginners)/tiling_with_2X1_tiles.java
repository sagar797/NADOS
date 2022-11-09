public class tiling_with_2X1_tiles {
    public static void main(String[] args) {
        int n = 8;

        int f = 1, s = 2;

        for (int i = 3; i <= n; i++) {
            int t = f + s;
            f = s;
            s = t;
        }

        System.out.println(s);
    }
}
