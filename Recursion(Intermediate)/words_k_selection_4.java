import java.util.HashMap;

public class words_k_selection_4 {
    public static void main(String[] args) {
        String s = "aabbbccdde";
        int k = 3;

        HashMap<Character, Integer> fMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!fMap.containsKey(ch)) {
                sb.append(ch);
                fMap.put(ch, 1);
            } else {
                fMap.put(ch, fMap.get(ch) + 1);
            }
        }

        solution(0, sb.toString(), fMap, k, "");
    }

    private static void solution(int idx, String s, HashMap<Character, Integer> fMap, int k, String asf) {
        if (k < 0)
            return;

        if (k == 0) {
            System.out.println(asf);
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            char ch = s.charAt(i);
            int freq = fMap.get(ch);
            if (freq > 0) {
                fMap.put(ch, freq - 1);
                solution(i, s, fMap, k - 1, asf + ch);
                fMap.put(ch, freq);
            }
        }
    }
}
