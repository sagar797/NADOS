import java.util.HashSet;

public class words_k_length_word_2 {
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

        solution(s, k, "");
    }

    private static void solution(String s, int k, String asf) {
        if (k < 0)
            return;

        if (k == 0)
            System.out.println(asf);

        if (s.length() == 0)
            return;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String roq = s.substring(0, i) + s.substring(i + 1);
            solution(roq, k - 1, asf + ch);
        }
    }
}
