import java.util.HashSet;

public class words_k_selection_1 {
    public static void main(String[] args) {
        String s = "aabbbccdde";
        int k = 3;

        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!set.contains(ch)) {
                set.add(ch);
                sb.append(ch);
            }
        }

        s = sb.toString();

        solution(s, 0, k, "");
    }

    private static void solution(String s, int idx, int k, String asf) {
        if (k == 0) {
            System.out.println(asf);
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            solution(s, i + 1, k - 1, asf + s.charAt(i));
        }
    }
}
