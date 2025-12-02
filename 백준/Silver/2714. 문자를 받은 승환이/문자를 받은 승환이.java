import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] argStrs = br.readLine().trim().split(" ");
            int R = Integer.parseInt(argStrs[0]);
            int C = Integer.parseInt(argStrs[1]);
            boolean[][] visited = new boolean[R][C];
            boolean[][] numBoard = new boolean[R][C];

            char[] inputData = argStrs[2].toCharArray();

            int idx = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    numBoard[i][j] = (inputData[idx++] == '1');
                }
            }

            int r = 0, c = 0, dir = 0;
            StringBuilder words = new StringBuilder();

            for (int t = 0; t < R * C; t++) {
                visited[r][c] = true;
                words.append(numBoard[r][c] ? '1' : '0');

                int[] d = getDirV(dir);
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C || visited[nr][nc]) {
                    dir = (dir + 1) % 4;
                    d = getDirV(dir);
                }

                r += d[0];
                c += d[1];
            }

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < words.length(); i += 5) {
                if (i + 5 > words.length()) break;

                String s = words.substring(i, i + 5);
                int val = Integer.parseInt(s, 2);

                if (val == 0) result.append(' ');
                else result.append((char) ('A' + val - 1));
            }

            // 결과 문자열의 끝(우측) 공백 제거
            while (result.length() > 0 && result.charAt(result.length() - 1) == ' ') {
                result.deleteCharAt(result.length() - 1);
            }

            System.out.println(result.toString());
        }
    }

    static int[] getDirV(int dir) {
        switch (dir) {
            case 0: return new int[]{0, 1};
            case 1: return new int[]{1, 0};
            case 2: return new int[]{0, -1};
            default: return new int[]{-1, 0};
        }
    }
}
