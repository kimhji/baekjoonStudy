import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] A = new int[5][5];
        int[][] B = new int[5][5];

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[] total = new long[5];

        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                for (int i = 0; i < 5; i++) {
                    total[x] += (long) A[x][i] * B[i][y];
                }
            }
        }

        String[] names = {
            "Inseo", "Junsuk", "Jungwoo", "Jinwoo", "Youngki"
        };

        long min = Long.MAX_VALUE;
        int idx = 0;

        for (int i = 4; i >= 0; i--) {
            if (total[i] < min) {
                min = total[i];
                idx = i;
            }
        }

        System.out.println(names[idx]);
    }
}
