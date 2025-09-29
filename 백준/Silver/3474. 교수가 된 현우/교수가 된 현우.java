import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine().trim());
            long count_5 = 0;

            for (long j = 5; j <= N; j *= 5) {
                count_5 += N / j;
            }

            System.out.println(count_5);
        }
    }
}
