import java.io.*;
import java.util.*;

class Main {
    public static boolean checkAllSame(char[][] board, int start_r, int start_c, int size){
        char standard = board[start_r][start_c];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[start_r+i][start_c+j] != standard) return false;
            }
        }
        return true;
    }

    public static String solve(char[][] board, int start_r, int start_c, int size){
        if(checkAllSame(board, start_r, start_c, size)) return String.valueOf(board[start_r][start_c]);
        String result = "(";
        result += solve(board, start_r, start_c, size/2);
        result += solve(board, start_r, start_c+size/2, size/2);
        result += solve(board, start_r+size/2, start_c, size/2);
        result += solve(board, start_r+size/2, start_c+size/2, size/2);
        return result + ")";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        char[][] board = new char[N][N];
        for(int i = 0;i<N;i++){
            char[] line = br.readLine().trim().toCharArray();
            for(int j = 0;j<N;j++){
                board[i][j] = line[j];
            }
        }
        String result = solve(board, 0,0,N);
        System.out.println(result);
    }
}