import java.util.HashSet;

public class words_k_length_word_1 {
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

        Character[] spots = new Character[k];

        solution(0, s, k, spots, "");
    }

    private static void solution(int idx, String s, int k, Character[] spots, String asf) {
        if (idx == s.length()) {
            if (k == 0) {
                for (int i = 0; i < spots.length; i++) {
                    System.out.print(spots[i]);
                }
                System.out.println();
            }
            return;
        }

        char ch = s.charAt(idx);

        for (int i = 0; i < spots.length; i++) {
            if (spots[i] == null) {
                spots[i] = ch;
                solution(idx + 1, s, k - 1, spots, asf + ch);
                spots[i] = null;
            }
        }

        solution(idx + 1, s, k, spots, asf);
    }
}