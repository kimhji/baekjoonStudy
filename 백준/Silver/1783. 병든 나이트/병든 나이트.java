import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int result;

        if (N == 1) {
            result = 1;  // 이동 불가능
        } else if (N == 2) {
            result = Math.min(4, (M + 1) / 2); // 최대 4칸 이동
        } else {
            if (M < 7) {
                result = Math.min(4, M); // 최대한 많이 가도 4칸
            } else {
                result = M - 2; // 자유롭게 이동 가능
            }
        }

        System.out.println(result);
    }
}
