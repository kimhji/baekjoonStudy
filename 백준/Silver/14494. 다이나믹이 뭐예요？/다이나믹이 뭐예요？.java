import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().trim().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        int[][] board = new int[N][M];
        
        for(int i = 0;i<N;i++) {
        	for(int j = 0;j<M;j++) {
        		board[i][j] = 0;
        		if(i>0) {
        			board[i][j] += board[i-1][j];
        			board[i][j] %= 1000000007;
        		}
        		if(j>0) {
        			board[i][j] += board[i][j-1];
        			board[i][j] %= 1000000007;
        		}
        		if(i>0 && j>0) {
        			board[i][j] += board[i-1][j-1];
        			board[i][j] %= 1000000007;
        		}
        		if(board[i][j] == 0) board[i][j] = 1;
        	}
        }
        System.out.println(board[N-1][M-1]);
    }
}