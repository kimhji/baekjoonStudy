
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] numStr = br.readLine().trim().split(" ");
        int N = Integer.parseInt(numStr[0]);
        int M = Integer.parseInt(numStr[1]);

        Map<Character, Integer> answer = new HashMap<Character, Integer>();
        Map<Character, Integer> tns = new HashMap<Character, Integer>();

        char[] W = br.readLine().trim().toCharArray();
        char[] S = br.readLine().trim().toCharArray();
        int idx_f = 0;
        int idx_b = 0;
        int result = 0;
        for (char ch : W) {
            answer.put(ch, answer.getOrDefault(ch, 0) + 1);
        }
        tns.put(S[idx_b], 1);
        while (idx_b < M) {
            if (idx_b - idx_f + 1 < N) {
                idx_b++;
                if (idx_b >= M) {
                    break;
                }
                tns.put(S[idx_b], tns.getOrDefault(S[idx_b], 0) + 1);
            }
            if (idx_b - idx_f + 1 > N) {
                tns.put(S[idx_f], tns.get(S[idx_f]) - 1);
                idx_f++;
                continue;
            }
            boolean isOkay = true;
            for (Character ch : answer.keySet()) {
                if ((tns.getOrDefault(ch, 0) - answer.getOrDefault(ch, 0)) != 0) {
                    isOkay = false;
                    break;
                }
            }
            if (isOkay) {
                result++;
            }
            idx_b++;
            if (idx_b >= M) {
                break;
            }
            tns.put(S[idx_b], tns.getOrDefault(S[idx_b], 0) + 1);
        }
        System.out.println(result);
    }
}
