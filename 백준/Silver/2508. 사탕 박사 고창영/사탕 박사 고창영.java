
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < T; i++) {
            br.readLine();
            String[] data = br.readLine().trim().split(" ");
            int N = Integer.parseInt(data[0]);
            int M = Integer.parseInt(data[1]);
            char[][] board = new char[N][M];

            for (int j = 0; j < N; j++) {
                board[j] = br.readLine().trim().toCharArray();
            }
            int result = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (k + 2 < M && board[j][k] == '>' && board[j][k + 1] == 'o' && board[j][k + 2] == '<') {
                        result++;
                    }
                    if (j + 2 < N && board[j][k] == 'v' && board[j + 1][k] == 'o' && board[j + 2][k] == '^') {
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }
}
