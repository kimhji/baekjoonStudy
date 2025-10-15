import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] argStr = br.readLine().trim().split(" ");

        int N = Integer.parseInt(argStr[0]);
        int M = Integer.parseInt(argStr[1]);
        boolean[][] isWall = new boolean[N][M];
        int[][] visitTime_0 = new int[N][M];
        int[][] visitTime_1 = new int[N][M];

        for(int i = 0;i<N;i++){
            int j = 0;
            for(char ch: br.readLine().trim().toCharArray()){
                isWall[i][j] = ch=='1';
                visitTime_0[i][j] = -1;
                visitTime_1[i][j] = -1;
                j++;
            }
        }

        List<int[]> bag = new LinkedList<int[]>();
        bag.add(new int[]{0,0});
        visitTime_0[0][0] = 1;
        if(N == 1 && M == 1){
            System.out.println(1);
            return;
        }
        int count = 1;
        int result = -1;
        while(bag.size()>0 && result<0){
            count++;
            List<int[]> nextBag = new LinkedList<int[]>();
            for(int[] loc:bag){
                if(loc[0]>0){
                    int[] tnsLoc = new int[]{loc[0]-1, loc[1]};
                    boolean isNeedToAdd = needToAdd(tnsLoc, loc, visitTime_0, visitTime_1, isWall, count);
                    if(isNeedToAdd){
                        if(tnsLoc[0] == N-1 && tnsLoc[1] == M-1){
                            result = count;
                            break;
                        }
                        nextBag.add(tnsLoc);
                    }
                }
                if(loc[1]>0){
                    int[] tnsLoc = new int[]{loc[0], loc[1]-1};
                    boolean isNeedToAdd = needToAdd(tnsLoc, loc, visitTime_0, visitTime_1, isWall, count);
                    if(isNeedToAdd){
                        if(tnsLoc[0] == N-1 && tnsLoc[1] == M-1){
                            result = count;
                            break;
                        }
                        nextBag.add(tnsLoc);
                    }
                    
                }
                if(loc[0]<N-1){
                    int[] tnsLoc = new int[]{loc[0]+1, loc[1]};
                    boolean isNeedToAdd = needToAdd(tnsLoc, loc, visitTime_0, visitTime_1, isWall, count);
                    if(isNeedToAdd){
                        if(tnsLoc[0] == N-1 && tnsLoc[1] == M-1){
                            result = count;
                            break;
                        }
                        nextBag.add(tnsLoc);
                    }
                    
                }
                if(loc[1]<M-1){
                    int[] tnsLoc = new int[]{loc[0], loc[1]+1};
                    boolean isNeedToAdd = needToAdd(tnsLoc, loc, visitTime_0, visitTime_1, isWall, count);
                    if(isNeedToAdd){
                        if(tnsLoc[0] == N-1 && tnsLoc[1] == M-1){
                            result = count;
                            break;
                        }
                        nextBag.add(tnsLoc);
                    }
                }
            }

            bag = nextBag;
        }
        System.out.println(result);
        
        // for(int i = 0;i<N;i++){
        //     for(int j = 0;j<M;j++){
        //         System.out.print(visitTime_0[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // for(int i = 0;i<N;i++){
        //     for(int j = 0;j<M;j++){
        //         System.out.print(visitTime_1[i][j]+" ");
        //     }
        //     System.out.println();
        // }
    }

    static boolean needToAdd(int[] tnsLoc, int[] loc, int[][] visitTime_0, int[][] visitTime_1, boolean[][] isWall, int count){
        boolean isNeedToAdd = false;
        if(isWall[tnsLoc[0]][tnsLoc[1]]){
            if(visitTime_0[loc[0]][loc[1]]>=0 &&
                (count < visitTime_1[tnsLoc[0]][tnsLoc[1]]
                || visitTime_1[tnsLoc[0]][tnsLoc[1]] < 0)){
                visitTime_1[tnsLoc[0]][tnsLoc[1]] = count;
                isNeedToAdd = true;
                }
            
        }
        else{
            if(visitTime_1[loc[0]][loc[1]]>=0 &&
                (count < visitTime_1[tnsLoc[0]][tnsLoc[1]]
                || visitTime_1[tnsLoc[0]][tnsLoc[1]] < 0)){
                visitTime_1[tnsLoc[0]][tnsLoc[1]] = count;
                isNeedToAdd = true;
            }
            if(visitTime_0[loc[0]][loc[1]]>=0 && (count < visitTime_0[tnsLoc[0]][tnsLoc[1]]
                || visitTime_0[tnsLoc[0]][tnsLoc[1]] < 0)){
                visitTime_0[tnsLoc[0]][tnsLoc[1]] = count;
                isNeedToAdd = true;
                }
        }
        return isNeedToAdd;
    }
}