import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        // Solve
        int[][] status = new int[3][N];
        /*
        0 : a + b
        1 : b + c
        2 : c + a
         */
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            final int a = Integer.parseInt(st.nextToken());
            final int b = Integer.parseInt(st.nextToken());
            final int c = Integer.parseInt(st.nextToken());
            status[0][i] = a + b;
            status[1][i] = b + c;
            status[2][i] = c + a;
        }
        for (int i = 0; i < 3; ++i) {
            Arrays.sort(status[i]);
        }

        int[] sumStatus = new int[3];
        for (int k = N - 1; k >= N - K; --k) {
            sumStatus[0] += status[0][k];
            sumStatus[1] += status[1][k];
            sumStatus[2] += status[2][k];
        }

        // Output
        System.out.println(Math.max(sumStatus[0],
                Math.max(sumStatus[1], sumStatus[2])));
    }
}