import java.util.HashMap;

public class words_k_length_word_4 {
    public static void main(String[] args) {
        String s = "aaabb";
        int k = 3;

        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder uniqueStr = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!map.containsKey(ch)) {
                uniqueStr.append(ch);
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }

        solution(uniqueStr, map, k, "");
    }

    private static void solution(StringBuilder uniqueStr, HashMap<Character, Integer> map, int k, String asf) {
        if (k == 0) {
            System.out.println(asf);
            return;
        }

        if (k < 0)
            return;

        for (int i = 0; i < uniqueStr.length(); i++) {
            char ch = uniqueStr.charAt(i);
            int freq = map.get(ch);
            if (freq > 0) {
                map.put(ch, freq - 1);
                solution(uniqueStr, map, k - 1, asf + ch);
                map.put(ch, freq);
            }
        }
    }
}
