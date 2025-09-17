import java.io.*;
import java.util.*;

class Main {
    static int[][] dirs = new int[][]{
        {-1, -1}, {-1, 0}, {0, -1}
        , {1, -1}, {-1, 1}, {1, 1}
        , {0, 1}, {1, 0}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] argStr = br.readLine().trim().split(" ");
        int N = Integer.parseInt(argStr[0]);
        int M = Integer.parseInt(argStr[1]);

        int[][] heights = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        for(int i = 0;i<N;i++){
            argStr = br.readLine().trim().split(" ");
            for(int j = 0;j<M;j++){
                heights[i][j] = Integer.parseInt(argStr[j]);
            }
        }

        int count = 0;
        for(int i = 0;i<N;i++){
            for(int j = 0;j<M;j++){
                if(visited[i][j]) continue;
                if(heights[i][j] == 0) continue;
                count++;
                List<int[]> locs = new LinkedList<int[]>();
                List<int[]> highestLocs = new LinkedList<int[]>();
                int[] firstLoc = new int[]{i, j};
                locs.add(firstLoc);
                highestLocs.add(firstLoc);
                int h = heights[i][j];
                
                boolean[][] tnsVisited = new boolean[N][M];
                tnsVisited[i][j] = true;
                while(locs.size()>0){
                    List<int[]> nextLocs = new LinkedList<int[]>();
                    boolean isUpdateH = false;
                    for(int[] loc: locs){
                        for(int[] dir: dirs){
                            int[] tnsLoc = new int[]{dir[0]+loc[0], dir[1]+loc[1]};
                            if(tnsLoc[0] < 0 || tnsLoc[1] < 0
                            || tnsLoc[0] >= N || tnsLoc[1] >= M) continue;
                            if(tnsVisited[tnsLoc[0]][tnsLoc[1]] || visited[tnsLoc[0]][tnsLoc[1]]) continue;
                            if(heights[tnsLoc[0]][tnsLoc[1]] > h){
                                tnsVisited[tnsLoc[0]][tnsLoc[1]] = true;
                                h = heights[tnsLoc[0]][tnsLoc[1]];
                                isUpdateH = true;
                                highestLocs.clear();
                                nextLocs.clear();
                                nextLocs.add(tnsLoc);
                                highestLocs.add(tnsLoc);
                                break;
                            }
                            else if(heights[tnsLoc[0]][tnsLoc[1]] == h){
                                tnsVisited[tnsLoc[0]][tnsLoc[1]] = true;
                                nextLocs.add(tnsLoc);
                                highestLocs.add(tnsLoc);
                            }
                        }
                        if(isUpdateH) break;
                    }
                    locs = nextLocs;
                }

                // for(int[] loc: highestLocs){
                //     System.out.println(loc[0]+" "+loc[1]);
                // }
                // System.out.println("find all size");
                while(highestLocs.size()>0){
                    List<int[]> nextLocs = new LinkedList<int[]>();

                    for(int[] loc: highestLocs){
                        visited[loc[0]][loc[1]] = true;
                        for(int[] dir: dirs){
                            int[] tnsLoc = new int[]{dir[0]+loc[0], dir[1]+loc[1]};
                            if(tnsLoc[0] < 0 || tnsLoc[1] < 0
                            || tnsLoc[0] >= N || tnsLoc[1] >= M) continue;
                            //System.out.println("find "+tnsLoc[0]+" "+tnsLoc[1] +":"+loc[0]+" "+loc[1] + " "+ (visited[tnsLoc[0]][tnsLoc[1]]?"true":"false"));
                            if(visited[tnsLoc[0]][tnsLoc[1]]) continue;
                            if(heights[tnsLoc[0]][tnsLoc[1]] <= heights[loc[0]][loc[1]]){
                                visited[tnsLoc[0]][tnsLoc[1]] = true;
                                nextLocs.add(tnsLoc);
                                //System.out.println(tnsLoc[0]+" "+tnsLoc[1]);
                            }
                        }
                    }
                    highestLocs = nextLocs;
                }
            }
        }
        System.out.println(count);
    }
}