import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] isDangerBoard = new boolean[501][501];
        boolean[][] isDeathBoard = new boolean[501][501];
        int[][] board = new int[501][501];
        
        int dangerAreaN = Integer.parseInt(br.readLine().trim());
        for(int i = 0;i<dangerAreaN;i++){
            String[] argStrs = br.readLine().trim().split(" ");
            int x1 = Integer.parseInt(argStrs[0]);
            int y1 = Integer.parseInt(argStrs[1]);
            int x2 = Integer.parseInt(argStrs[2]);
            int y2 = Integer.parseInt(argStrs[3]);
            int minX = Math.min(x1, x2);
            int minY = Math.min(y1, y2);
            int maxX = Math.max(x1, x2);
            int maxY = Math.max(y1, y2);
            for(int x = minX;x<=maxX;x++){
                for(int y = minY;y<=maxY;y++){
                    isDangerBoard[y][x] = true;
                }
            }
        }

        int deathAreaN = Integer.parseInt(br.readLine().trim());

        for(int i = 0;i<deathAreaN;i++){
            String[] argStrs = br.readLine().trim().split(" ");
            int x1 = Integer.parseInt(argStrs[0]);
            int y1 = Integer.parseInt(argStrs[1]);
            int x2 = Integer.parseInt(argStrs[2]);
            int y2 = Integer.parseInt(argStrs[3]);
            int minX = Math.min(x1, x2);
            int minY = Math.min(y1, y2);
            int maxX = Math.max(x1, x2);
            int maxY = Math.max(y1, y2);
            for(int x = minX;x<=maxX;x++){
                for(int y = minY;y<=maxY;y++){
                    isDeathBoard[y][x] = true;
                }
            }
        }

        for(int i = 0;i<=500;i++){
            for(int j = 0;j<=500;j++){
                board[i][j] = -1;
                //System.out.print(isDeathBoard[i][j]?2:isDangerBoard[i][j]?1:"0");
            }
            //System.out.println();
        }
        List<int[]> locBag = new LinkedList<int[]>();
        board[0][0] = 0;
        locBag.add(new int[]{0,0});
        while(locBag.size() > 0){
            List<int[]> nextBag = new LinkedList<int[]>();
            for(int[] loc:locBag){
                int[] tnsLoc = new int[]{loc[0]+1, loc[1]};
                if(loc[0]<500 && !isDeathBoard[tnsLoc[0]][tnsLoc[1]]){
                    int hurt = isDangerBoard[tnsLoc[0]][tnsLoc[1]]?1:0;
                    if(board[tnsLoc[0]][tnsLoc[1]]<0 || board[tnsLoc[0]][tnsLoc[1]]>board[loc[0]][loc[1]]+hurt){
                        board[tnsLoc[0]][tnsLoc[1]] = board[loc[0]][loc[1]]+hurt;
                        nextBag.add(tnsLoc);
                    }
                }
                tnsLoc = new int[]{loc[0], loc[1]+1};
                if(loc[1]<500 && !isDeathBoard[tnsLoc[0]][tnsLoc[1]]){
                    int hurt = isDangerBoard[tnsLoc[0]][tnsLoc[1]]?1:0;
                    if(board[tnsLoc[0]][tnsLoc[1]]<0 || board[tnsLoc[0]][tnsLoc[1]]>board[loc[0]][loc[1]]+hurt){
                        board[tnsLoc[0]][tnsLoc[1]] = board[loc[0]][loc[1]]+hurt;
                        nextBag.add(tnsLoc);
                    }
                }
                tnsLoc = new int[]{loc[0]-1, loc[1]};
                if(loc[0]>0 && !isDeathBoard[tnsLoc[0]][tnsLoc[1]]){
                    int hurt = isDangerBoard[tnsLoc[0]][tnsLoc[1]]?1:0;
                    if(board[tnsLoc[0]][tnsLoc[1]]<0 || board[tnsLoc[0]][tnsLoc[1]]>board[loc[0]][loc[1]]+hurt){
                        board[tnsLoc[0]][tnsLoc[1]] = board[loc[0]][loc[1]]+hurt;
                        nextBag.add(tnsLoc);
                    }
                }
                tnsLoc = new int[]{loc[0], loc[1]-1};
                if(loc[1]>0 && !isDeathBoard[tnsLoc[0]][tnsLoc[1]]){
                    int hurt = isDangerBoard[tnsLoc[0]][tnsLoc[1]]?1:0;
                    if(board[tnsLoc[0]][tnsLoc[1]]<0 || board[tnsLoc[0]][tnsLoc[1]]>board[loc[0]][loc[1]]+hurt){
                        board[tnsLoc[0]][tnsLoc[1]] = board[loc[0]][loc[1]]+hurt;
                        nextBag.add(tnsLoc);
                    }
                }
            }
            locBag = nextBag;
        }
        System.out.println(board[500][500]);
    }
}