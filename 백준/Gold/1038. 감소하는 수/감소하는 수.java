import java.io.*;
import java.util.*;

public class Main {
    static List<Long> numbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        // 모든 줄어드는 수 생성
        for (int i = 0; i < 10; i++) {
            dfs(i, i);
        }

        Collections.sort(numbers);

        if (N >= numbers.size()) {
            System.out.println(-1);
        } else {
            System.out.println(numbers.get(N));
        }
    }

    // DFS로 줄어드는 수 만들기
    static void dfs(long num, int lastDigit) {
        numbers.add(num);
        for (int next = 0; next < lastDigit; next++) {
            dfs(num * 10 + next, next);
        }
    }
}
