import java.io.*;
import java.util.*;

class Shortcut {
    int start, end, dist;

    Shortcut(int s, int e, int d) {
        start = s;
        end = e;
        dist = d;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 지름길 수
        int D = Integer.parseInt(st.nextToken()); // 고속도로 길이

        List<Shortcut> shortcuts = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if (end - start > dist && end <= D) {
                shortcuts.add(new Shortcut(start, end, dist));
            }
        }

        // 거리 배열: i 까지 가는 최소 거리
        int[] dp = new int[D + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i <= D; i++) {
            // 1. i+1로 가는 일반 도로
            if (i + 1 <= D && dp[i] + 1 < dp[i + 1]) {
                dp[i + 1] = dp[i] + 1;
            }

            // 2. i에서 시작하는 지름길
            for (Shortcut s : shortcuts) {
                if (s.start == i) {
                    if (dp[i] + s.dist < dp[s.end]) {
                        dp[s.end] = dp[i] + s.dist;
                    }
                }
            }
        }

        System.out.println(dp[D]);
    }
}
