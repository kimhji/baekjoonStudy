import java.io.*;
import java.util.*;

class Main {
    public static int[][] dirs = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };
    public static List<int[]> spreadFire(char[][] board, List<int[]> fire, int N, int M){
        List<int[]> nextFire = new LinkedList<int[]>();
        for(int[] loc: fire){
            for(int[] dir: dirs){
                int[] nextLoc = new int[]{loc[0]+dir[0], loc[1]+dir[1]};
                if(nextLoc[0]<0 || nextLoc[0] >= N
                || nextLoc[1]<0 || nextLoc[1] >= M ) continue;

                if(board[nextLoc[0]][nextLoc[1]] == '#'
                || board[nextLoc[0]][nextLoc[1]] == 'F') continue;
                board[nextLoc[0]][nextLoc[1]] = 'F';
                nextFire.add(nextLoc);
            }
        }
        return nextFire;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] argStr = br.readLine().trim().split(" ");
        int N = Integer.parseInt(argStr[0]);
        int M = Integer.parseInt(argStr[1]);
        
        char[][] board = new char[N][];
        boolean[][] visited = new boolean[N][M];
        List<int[]> fires = new LinkedList<int[]>();
        List<int[]> locs = new LinkedList<int[]>();
        List<int[]> nextLocs;
        for(int i = 0;i<N;i++){
            board[i] = br.readLine().trim().toCharArray();
            for(int j = 0;j<M;j++){
                if(board[i][j] == 'J'){
                    visited[i][j] = true;
                    locs.add(new int[]{i, j});
                }
                if(board[i][j] == 'F'){
                    fires.add(new int[]{i, j});
                }
            }
        }
        int count = 0;
        while(locs.size() > 0){
            count++;
            nextLocs = new LinkedList<int[]>();
            fires = spreadFire(board, fires, N, M);
            for(int[] loc:locs){
                for(int[] dir: dirs){
                    int[] nextLoc = new int[]{loc[0]+dir[0], loc[1]+dir[1]};
                    if(nextLoc[0]<0 || nextLoc[0] >= N
                    || nextLoc[1]<0 || nextLoc[1] >= M ) {
                        System.out.println(count);
                        return;
                    }
                    if(board[nextLoc[0]][nextLoc[1]] == '#'
                    || board[nextLoc[0]][nextLoc[1]] == 'F') continue;
                    if(visited[nextLoc[0]][nextLoc[1]]) continue;
                    visited[nextLoc[0]][nextLoc[1]] = true;
                    nextLocs.add(nextLoc);
                }
            }
            locs = nextLocs;
        }
        System.out.println("IMPOSSIBLE");
    }
}