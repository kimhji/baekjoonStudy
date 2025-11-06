import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] numbers;
    static boolean[] visited;
    static int[] perm;
    static int maxResult = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        numbers = new int[N];
        String[] data = br.readLine().trim().split(" ");
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(data[i]);
        }

        visited = new boolean[N];
        perm = new int[N];

        backtrack(0);

        System.out.println(maxResult);
    }

    static void backtrack(int depth) {
        if (depth == N) {
            maxResult = Math.max(maxResult, calculate(perm));
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                perm[depth] = numbers[i];
                backtrack(depth + 1);
                visited[i] = false;
            }
        }
    }

    static int calculate(int[] arr) {
        int sum = 0;
        for (int i = 0; i < N - 1; i++) {
            sum += Math.abs(arr[i] - arr[i + 1]);
        }
        return sum;
    }
}
