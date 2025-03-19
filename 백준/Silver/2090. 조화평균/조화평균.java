import java.io.*;
import java.util.*;

public class Main {
    // 최대공약수(GCD) 함수
    public static long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    // 최소공배수(LCM) 함수
    public static long lcm(long a, long b) {
        return (a / gcd(a, b)) * b; // 오버플로우 방지를 위해 나누기를 먼저 수행
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        long[][] v = new long[n][2]; // C++의 vector<pair<long long, long long>> 대체
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            v[i][1] = Long.parseLong(st.nextToken()); // yy = 분모
            v[i][0] = 1; // xx = 분자
        }

        long a = v[0][0], b = v[0][1];

        for (int i = 1; i < n; i++) {
            long lcmv = lcm(v[i][1], b); // 현재 분모와 기존 분모의 최소공배수 구하기
            v[i][0] = (lcmv / v[i][1]) * v[i][0]; // 분자 변환
            a = (lcmv / b) * a + v[i][0]; // 새로운 분자 업데이트
            b = lcmv; // 새로운 분모 업데이트
        }

        long gcdv = gcd(a, b);

        System.out.println((b / gcdv) + "/" + (a / gcdv));
    }
}
