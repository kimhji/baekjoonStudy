import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            // 원래 큐
            String[] original = new String[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                original[i] = st.nextToken();
            }

            // 결과 큐
            String[] result = new String[m];

            // 시작 위치 사용 여부
            boolean[] usedStart = new boolean[m];

            // 연산 입력 저장
            int[] from = new int[n];
            int[] to = new int[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                from[i] = Integer.parseInt(st.nextToken()) - 1;
                to[i] = Integer.parseInt(st.nextToken()) - 1;
            }

            // 1️⃣ 연산 먼저 동시에 배치
            for (int i = 0; i < n; i++) {
                result[to[i]] = original[from[i]];
                usedStart[from[i]] = true;
            }

            // 2️⃣ 남은 아이템을 순서대로 빈 칸에 채움
            int idx = 0;
            for (int i = 0; i < m; i++) {
                if (result[i] != null) continue;

                while (usedStart[idx]) idx++;
                result[i] = original[idx];
                idx++;
            }

            // 출력
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(result[i]);
                if (i < m - 1) sb.append(" ");
            }
            System.out.println(sb);
        }
    }
}
