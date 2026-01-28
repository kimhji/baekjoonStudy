import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine().trim());

        long[] cnt = new long[10];
        long add = 0;

        for (long i = 1; N != 0; i *= 10) {
            long curr = N % 10;
            N /= 10;

            cnt[0] -= i;

            for (int j = 0; j < curr; j++) {
                cnt[j] += (N + 1) * i;
            }

            cnt[(int) curr] += N * i + 1 + add;

            for (int j = (int) curr + 1; j <= 9; j++) {
                cnt[j] += N * i;
            }

            add += curr * i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++) {
            sb.append(cnt[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
