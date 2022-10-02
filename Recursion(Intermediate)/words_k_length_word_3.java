import java.util.HashMap;

public class words_k_length_word_3 {
    public static void main(String[] args) {
        String s = "aaabb";
        int k = 3;

        Character[] spots = new Character[k];
        HashMap<Character, Integer> lastOccurence = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            lastOccurence.put(ch, -1);
        }

        solution(0, spots, s, lastOccurence, k);
    }

    private static void solution(int idx, Character[] spots, String str,
            HashMap<Character, Integer> lastOccurence,
            int k) {
        if (idx == str.length()) {
            if (k == 0) {
                for (Character c : spots)
                    System.out.print(c);
                System.out.println();
            }
            return;
        }

        char ch = str.charAt(idx);
        int lo = lastOccurence.get(ch);

        for (int i = lo + 1; i < spots.length; i++) {
            if (spots[i] == null) {
                spots[i] = ch;
                lastOccurence.put(ch, i);
                solution(idx + 1, spots, str, lastOccurence, k - 1);
                lastOccurence.put(ch, lo);
                spots[i] = null;
            }
        }

        if (lo == -1) {
            solution(idx + 1, spots, str, lastOccurence, k);
        }
    }
}
