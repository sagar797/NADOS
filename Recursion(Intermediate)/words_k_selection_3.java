import java.util.HashMap;

public class words_k_selection_3 {
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

        if (idx == s.length()) {
            if (k == 0)
                System.out.println(asf);
            return;
        }

        char ch = s.charAt(idx);
        int chFreq = fMap.get(ch);

        for (int i = chFreq; i >= 0; i--) {
            String temp = "";
            for (int j = 0; j < i; j++) {
                temp += ch;
            }

            solution(idx + 1, s, fMap, k - i, asf + temp);
        }
    }
}
