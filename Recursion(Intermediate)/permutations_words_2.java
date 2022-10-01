import java.util.HashMap;

public class permutations_words_2 {
    public static void main(String[] args) {
        String s = "abcd";
        HashMap<Character, Integer> map = new HashMap<>();

        // for (int i = 0; i < s.length(); i++) {
        // map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        // }
        // permutations_words_1_sol(map, s, "");

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), -1);
        }
        Character[] spots = new Character[s.length()];

        permutations_words_2_sol(map, 0, s, spots);
    }

    private static void permutations_words_2_sol(HashMap<Character, Integer> map, int idx, String s,
            Character[] spots) {
        if (idx == s.length()) {
            for (Character c : spots)
                System.out.print(c);
            System.out.println();
            return;
        }

        char ch = s.charAt(idx);
        int lastOccurence = map.get(ch);
        for (int i = lastOccurence + 1; i < s.length(); i++) {
            if (spots[i] != null)
                continue;

            map.put(ch, i);
            spots[i] = ch;
            permutations_words_2_sol(map, idx + 1, s, spots);
            spots[i] = null;
            map.put(ch, lastOccurence);
        }
    }

    private static void permutations_words_1_sol(HashMap<Character, Integer> map, String s, String asf) {
        if (asf.length() == s.length()) {
            System.out.println(asf);
            return;
        }

        for (Character ch : map.keySet()) {
            int freq = map.get(ch);
            if (freq == 0)
                continue;

            map.put(ch, freq - 1);
            permutations_words_1_sol(map, s, asf + ch);
            map.put(ch, freq);
        }
    }

}
