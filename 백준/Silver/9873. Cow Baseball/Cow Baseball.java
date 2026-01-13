import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] cows = new int[N];
        for (int i = 0; i < N; i++) {
            cows[i] = Integer.parseInt(br.readLine().trim());
        }
        Arrays.sort(cows);
        int result = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                int d1 = cows[j] - cows[i];
                for (int k = j + 1; k < N; k++) {
                    int d2 = cows[k] - cows[j];
                    if (d1 > d2) {
                        continue;
                    }
                    if(d2 > 2* d1) break;
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
