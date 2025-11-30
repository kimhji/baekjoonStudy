import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] data = br.readLine().trim().split(" ");
        int y_1 = Integer.parseInt(data[0])-1;
        int x_1 = Integer.parseInt(data[1])-1;

        data = br.readLine().trim().split(" ");
        int dest_y = Integer.parseInt(data[0])-1;
        int dest_x = Integer.parseInt(data[1])-1;

        int[][] board = new int[8][8];
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                board[i][j] = -1;
            }
        }

        List<int[]> bag = new LinkedList<int[]>();
        bag.add(new int[]{y_1, x_1});
        board[y_1][x_1] = 0;
        int moveCnt = 0;
        while(bag.size()>0 && board[dest_y][dest_x] < 0){
            moveCnt++;
            List<int[]> nextBag = new LinkedList<int[]>();
            for(int[] loc: bag){
                for(int c = 0;c<8;c++){
                    int[] tnsLoc = getDir(c, loc);
                    if(tnsLoc[0] < 0 || tnsLoc[1]<0
                        || tnsLoc[0] > 7 || tnsLoc[1] > 7
                    ) continue;
                    if(board[tnsLoc[0]][tnsLoc[1]] >= 0) continue;

                    nextBag.add(tnsLoc);
                    board[tnsLoc[0]][tnsLoc[1]] = moveCnt;
                }
            }

            bag = nextBag;
        }
        System.out.println(board[dest_y][dest_x]);
    }

    public static int[] getDir(int c, int[] loc){
        switch(c){
            case 0:
                return new int[]{loc[0]-2, loc[1]-1};
            case 1:
                return new int[]{loc[0]-1, loc[1]-2};
            case 2:
                return new int[]{loc[0]+1, loc[1]-2};
            case 3:
                return new int[]{loc[0]+2, loc[1]-1};
            case 4:
                return new int[]{loc[0]+1, loc[1]+2};
            case 5:
                return new int[]{loc[0]-2, loc[1]+1};
            case 6:
                return new int[]{loc[0]+2, loc[1]+1};
            default:
                return new int[]{loc[0]-1, loc[1]+2};
        }
    }
}