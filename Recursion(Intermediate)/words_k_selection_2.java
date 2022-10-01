import java.util.HashSet;

public class words_k_selection_2 {
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

        solution(0, s, k, "");
    }

    private static void solution(int idx, String s, int k, String asf) {
        if (k < 0)
            return;
        if (idx == s.length()) {
            if (k == 0)
                System.out.println(asf);
            return;
        }

        char ch = s.charAt(idx);

        solution(idx + 1, s, k - 1, asf + ch);
        solution(idx + 1, s, k, asf + "");
    }
}
