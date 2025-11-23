
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        char[] orders = br.readLine().trim().toCharArray();
        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = '.';
            }
        }

        int idx_y = 0;
        int idx_x = 0;

        for (char one : orders) {
            boolean isHori = (one == 'L' || one == 'R');

            if (one == 'L' && idx_x <= 0) {
                continue;
            }
            if (one == 'R' && idx_x >= N - 1) {
                continue;
            }
            if (one == 'U' && idx_y <= 0) {
                continue;
            }
            if (one == 'D' && idx_y >= N - 1) {
                continue;
            }
            char thisLoc = getShape(board[idx_y][idx_x], isHori);
            board[idx_y][idx_x] = thisLoc;

            if (one == 'L') {
                idx_x--;
            }
            if (one == 'R') {
                idx_x++;
            }
            if (one == 'U') {
                idx_y--;
            }
            if (one == 'D') {
                idx_y++;
            }
            char nextLoc = getShape(board[idx_y][idx_x], isHori);
            board[idx_y][idx_x] = nextLoc;
        }
        
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            System.out.print(board[i][j]);
                        }
                        System.out.println();
                    }
    }

    static char getShape(char origin, boolean isHori) {
        if (isHori && origin == '|'
                || !isHori && origin == '-') {
            return '+';
        } else if (isHori && origin == '.') {
            return '-';
        } else if (!isHori && origin == '.') {
            return '|';
        }
        return origin;
    }
}
