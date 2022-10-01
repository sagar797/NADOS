import java.util.HashSet;

public class permutations_words_1 {
    public static void main(String[] args) {
        String s = "aabb";

        permutations_words_1_sol(s, "", new HashSet<String>());
    }

    private static void permutations_words_1_sol(String s, String asf, HashSet<String> set) {
        if (s.length() == 0) {
            if (!set.contains(asf)) {
                set.add(asf);
                System.out.println(asf);
            }
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            String roq = s.substring(0, i) + s.substring(i + 1);
            permutations_words_1_sol(roq, asf + s.charAt(i), set);
        }
    }
}
