import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 선공 플레이어 번호 (1 또는 2)
        int start = Integer.parseInt(br.readLine().trim());

        int[][] board = new int[3][3];
        int currentPlayer = start;
        int result = 0;

        for (int turn = 0; turn < 9; turn++) {
            String line = br.readLine();
            if (result != 0) continue; // 승부 이미 난 경우 입력만 소모

            StringTokenizer st = new StringTokenizer(line);
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            board[r][c] = currentPlayer;

            if (checkWin(board, currentPlayer)) {
                result = currentPlayer;
            }

            currentPlayer = (currentPlayer == 1 ? 2 : 1);
        }

        System.out.println(result);
    }

    static boolean checkWin(int[][] b, int p) {
        for (int i = 0; i < 3; i++) {
            if (b[i][0] == p && b[i][1] == p && b[i][2] == p) return true;
            if (b[0][i] == p && b[1][i] == p && b[2][i] == p) return true;
        }
        if (b[0][0] == p && b[1][1] == p && b[2][2] == p) return true;
        if (b[0][2] == p && b[1][1] == p && b[2][0] == p) return true;

        return false;
    }
}
