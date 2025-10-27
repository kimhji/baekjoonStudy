import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long x = Long.parseLong(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (x == 0) {
            System.out.println(0);
            return;
        }

        boolean isNegative = false;
        if (b > 0 && x < 0) {
            isNegative = true;
            x = -x;
        }

        StringBuilder sb = new StringBuilder();

        while (x != 0) {
            long remainder = x % b;
            x = x / b;

            if (remainder < 0) {
                // 음의 진법일 때 나머지 보정
                remainder += Math.abs(b);
                x += 1;
            }

            sb.append(remainder);
        }

        if (isNegative) {
            sb.append('-');
        }

        System.out.println(sb.reverse().toString());
    }
}
