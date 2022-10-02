import java.util.ArrayList;
import java.util.List;

public class restore_ip_addresses {
    public static void main(String[] args) {
        // String s = "101023";
        String s = "25525511135";
        List<String> res = new ArrayList<>();

        // [1.0.10.23, 1.0.102.3, 10.1.0.23, 10.10.2.3, 101.0.2.3]
        solution(0, s, 4, res, ""); // because 4 is the only limit for an IP Address
        System.out.println(res);
    }

    private static void solution(int idx, String s, int k, List<String> res, String asf) {
        if (idx == s.length()) {
            if (k == 0) {
                res.add(asf.substring(0, asf.length() - 1));
            }
            return;
        }

        char ch = s.charAt(idx);
        if (ch == '0') {
            solution(idx + 1, s, k - 1, res, asf + "0.");
            return;
        }

        String temp = "";
        for (int i = idx; i < idx + 3 && i < s.length(); i++) {
            temp += s.charAt(i);
            if (Integer.parseInt(temp) <= 255) {
                solution(i + 1, s, k - 1, res, asf + temp + ".");
            }
        }
    }
}
