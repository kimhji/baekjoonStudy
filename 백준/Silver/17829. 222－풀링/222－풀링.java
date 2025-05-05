import java.util.*;
import java.io.*;


public class Main{	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String[] inputs;
        int[][] board = new int[N][N];
        for(int init = 0;init<N;init++) {
        	inputs = br.readLine().trim().split(" ");
        	for(int one =0;one<N;one++) {
        		board[init][one] = Integer.parseInt(inputs[one]);
        	}
        }
        
        while(N>1) {
        	N /= 2;
        	int[][] nextBoard = new int[N][N];
        	for(int y = 0;y<N;y++) {
        		for(int x = 0;x<N;x++) {
        			int[] tns = {board[y*2][x*2],board[y*2][x*2+1], board[y*2+1][x*2], board[y*2+1][x*2+1]};
        			Arrays.sort(tns);
        			nextBoard[y][x] = tns[2];
        		}
        	}
        	board = nextBoard;
        }
        System.out.print(board[0][0]);
	}
    
}