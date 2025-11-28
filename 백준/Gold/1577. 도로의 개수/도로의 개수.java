import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] argStrs = br.readLine().trim().split(" ");
        int W = Integer.parseInt(argStrs[0]);
        int H = Integer.parseInt(argStrs[1]);
        long[][] board = new long[W+1][H+1];
        Set<Road> cannotMoveOn = new HashSet<Road>();

        int N = Integer.parseInt(br.readLine().trim());
        for(int i = 0;i<N;i++){
            cannotMoveOn.add(new Road(br.readLine().trim()));
        }

        board[0][0] = 1L;
        for(int i = 0;i<=W;i++){
            for(int j = 0;j<=H;j++){
                Road tns_1 = new Road(i-1, j, i, j);
                if(i>0 && !cannotMoveOn.contains(tns_1)){
                    board[i][j] += board[i-1][j];
                }
                Road tns_2 = new Road(i, j-1, i, j);
                if(j>0 && !cannotMoveOn.contains(tns_2)){
                    board[i][j] += board[i][j-1];
                }
            }
        }
        System.out.println(board[W][H]);
    }
}

class Road{
    int loc_x1;
    int loc_y1;
    int loc_x2;
    int loc_y2;

    public Road(String inputStr){
        String[] argStrs = inputStr.trim().split(" ");
        int x1 = Integer.parseInt(argStrs[0]);
        int y1 = Integer.parseInt(argStrs[1]);
        int x2 = Integer.parseInt(argStrs[2]);
        int y2 = Integer.parseInt(argStrs[3]);
        this.loc_x1 = Math.min(x1, x2);
        this.loc_y1 = Math.min(y1, y2);
        this.loc_x2 = Math.max(x1, x2);
        this.loc_y2 = Math.max(y1, y2);
    }

    public Road(int x1, int y1, int x2, int y2){
        this.loc_x1 = x1;
        this.loc_y1 = y1;
        this.loc_x2 = x2;
        this.loc_y2 = y2;
    }

    @Override
    public int hashCode(){
        return Objects.hash(loc_x1, loc_y1, loc_x2, loc_y2);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(obj == null) return false;
        if (!(obj instanceof Road)) return false;

        Road other = (Road) obj;
        return loc_x1 == other.loc_x1 &&
               loc_y1 == other.loc_y1 &&
               loc_x2 == other.loc_x2 &&
               loc_y2 == other.loc_y2;
    }
}