
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 1. 사면체 수 목록 생성
        List<Integer> tetra = new ArrayList<>();
        for (int i = 1;; i++) {
            int t = i * (i + 1) * (i + 2) / 6;
            if (t > N) {
                break;
            }
            tetra.add(t);
        }

        // 2. DP
        int[] dp = new int[N + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int t : tetra) {
                if (i >= t && dp[i - t] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - t] + 1);
                }
            }
        }

        // 3. 출력
        System.out.println(dp[N]);
    }
}
