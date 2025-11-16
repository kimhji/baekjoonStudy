
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split(" ");
        int N = Integer.parseInt(line[0]);
        int S = Integer.parseInt(line[1]);

        line = br.readLine().trim().split(" ");
        int[] arr = new int[N + 1];
        arr[0] = 0;
        for (int i = 0; i < N; i++) {
            int tns = Integer.parseInt(line[i]);
            arr[i + 1] = arr[i] + tns;
        }

        int front_idx = 0;
        int result = -1;
        for (int i = 1; i <= N; i++) {
            while (front_idx < i && (arr[i] - arr[front_idx]) >= S) {
                if (result < 0 || result > (i - front_idx)) {
                    result = i - front_idx;
                }
                front_idx++;
            }
        }
        if (result < 0) {
            result = 0;
        }
        System.out.println(result);
    }
}
