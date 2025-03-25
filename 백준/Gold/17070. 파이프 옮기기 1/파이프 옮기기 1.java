import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[][][] board = new int[N][N][3];
		String[] line;
		for(int init = 0;init<N;init++) {
			line = br.readLine().trim().split(" ");
			for(int one = 0;one<N;one++) {
				int tns = Integer.parseInt(line[one]);
				if(tns == 1) {
					board[init][one][0] = -1;
					board[init][one][1] = -1;
					board[init][one][2] = -1;
				}
			}
		}
		board[0][1][0] = 1;
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				if(i == 0 && j==0) continue;
				if(board[i][j][0]<0) continue;
				
				if(j<N-1 && board[i][j+1][0] >= 0) board[i][j+1][0] += board[i][j][0] + board[i][j][2];
				if(i<N-1 && board[i+1][j][0] >= 0) board[i+1][j][1] += board[i][j][1] + board[i][j][2];
				if(j<N-1 && board[i][j+1][0] >= 0 && i<N-1 && board[i+1][j][0] >= 0&& board[i+1][j+1][0] >= 0) 
					board[i+1][j+1][2] += board[i][j][0] + board[i][j][1] + board[i][j][2];
			}
		}
		int sum = board[N-1][N-1][0]+board[N-1][N-1][1]+board[N-1][N-1][2];
		System.out.print(sum>0?sum:0);
	}
}