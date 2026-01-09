import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] D = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            D[i] = Integer.parseInt(st.nextToken()) - 1; // 0-index
        }

        int[] result = new int[N];
        for(int k = 0;k<K;k++){
            int[] tns = new int[N];
            for (int i = 0; i < N; i++) {
                tns[D[i]] = A[i];
            }
            A = tns;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(A[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
