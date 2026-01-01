
import java.io.*;

class Main {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] datas = br.readLine().split(" ");
        int N = Integer.parseInt(datas[0]);
        int M = Integer.parseInt(datas[1]);

        long[] dp = new long[N + 1];
        dp[0] = 1;

        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1];
            if (i >= M) {
                dp[i] = (dp[i] + dp[i - M]) % MOD;
            }
        }

        System.out.println(dp[N]);
    }
}
