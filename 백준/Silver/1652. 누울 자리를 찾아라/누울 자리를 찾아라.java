import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int horizontal = 0;
        int vertical = 0;

        // 가로 검사
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '.') {
                    cnt++;
                } else {
                    if (cnt >= 2) horizontal++;
                    cnt = 0;
                }
            }
            if (cnt >= 2) horizontal++;
        }

        // 세로 검사
        for (int j = 0; j < N; j++) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (map[i][j] == '.') {
                    cnt++;
                } else {
                    if (cnt >= 2) vertical++;
                    cnt = 0;
                }
            }
            if (cnt >= 2) vertical++;
        }

        System.out.println(horizontal + " " + vertical);
    }
}
