import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        dp = new int[10][N+1][4];

        for(int i=0; i<10; i++) {
            for(int j=0; j<=N; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        if(N < 10) {
            System.out.println("0");
            return;
        }
        int result = 0;
        for(int i = 1;i<=9;i++){
            result += getCount(i, 1, i==9?2:0);
            result %= 1000000000;
        }
        System.out.println(result);
    }
    public static int getCount(int value, int idx, int visitState) {
        int newVisitState = visitState;
        if(value == 0) newVisitState |= 1;
        if(value == 9) newVisitState |= 2;

        if(idx == N) {
            return (newVisitState == 3) ? 1 : 0;
        }

        if(dp[value][idx][newVisitState] != -1) return dp[value][idx][newVisitState];

        int res = 0;
        if(value < 9) {
            res += getCount(value + 1, idx + 1, newVisitState) % 1000000000;
        }
        if(value > 0) {
            res += getCount(value - 1, idx + 1, newVisitState) % 1000000000;;
        }
        res %= 1000000000;
        dp[value][idx][newVisitState] = res;
        return res;
    }
}