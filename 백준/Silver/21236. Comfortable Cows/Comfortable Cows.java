import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 1005;
    static boolean[][] cow = new boolean[MAX][MAX];
    static int[][] adj = new int[MAX][MAX];

    static int comfortable = 0;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static boolean isComfortable(int x, int y) {
        return cow[x][y] && adj[x][y] == 3;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= MAX || ny >= MAX) continue;
                if (isComfortable(nx, ny)) comfortable--;
            }

            cow[x][y] = true;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= MAX || ny >= MAX) continue;
                if (cow[nx][ny]) {
                    adj[nx][ny]++;
                    adj[x][y]++;
                }
            }

            if (isComfortable(x, y)) comfortable++;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= MAX || ny >= MAX) continue;
                if (isComfortable(nx, ny)) comfortable++;
            }

            sb.append(comfortable).append('\n');
        }

        System.out.print(sb);
    }
}
