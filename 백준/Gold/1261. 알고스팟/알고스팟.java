import java.io.*;
import java.util.*;

class Main {
    static int[][] dirs = new int[][]{
        {0, -1},
        {0, 1},
        {1, 0},
        {-1, 0}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] argStr = br.readLine().trim().split(" ");
        int N = Integer.parseInt(argStr[1]);
        int M = Integer.parseInt(argStr[0]);

        boolean[][] isWall = new boolean[N][M];
        int[][] countData = new int[N][M];
        for(int i = 0;i<N;i++){
            char[] line = br.readLine().trim().toCharArray();
            for(int j = 0;j<M;j++){
                isWall[i][j] = line[j]=='1';
                countData[i][j] = Integer.MAX_VALUE;
            }
        }
        LinkedList<int[]> locs = new LinkedList<int[]>();
        locs.add(new int[]{0,0,0});
        countData[0][0] = 0;
        while(locs.size()>0){
            LinkedList<int[]> nextLocs = new LinkedList<int[]>();
            for(int[] loc: locs){
                for(int[] dir: dirs){
                    int[] tnsLoc = new int[]{
                        loc[0]+dir[0],
                        loc[1]+dir[1]
                    };
                    if(tnsLoc[0] < 0 || tnsLoc[0]>=N ||
                    tnsLoc[1]< 0 || tnsLoc[1]>=M) continue;
                    int tnsCount = countData[loc[0]][loc[1]];
                    if(isWall[tnsLoc[0]][tnsLoc[1]]) tnsCount++;
                    if(countData[tnsLoc[0]][tnsLoc[1]] > tnsCount){
                        countData[tnsLoc[0]][tnsLoc[1]] = tnsCount;
                        nextLocs.add(tnsLoc);
                    }
                }
            }
            locs = nextLocs;
        }
        System.out.println(countData[N-1][M-1]);
    }
}