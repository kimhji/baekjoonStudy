import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().trim().split(" ");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		int[][] board = new int[N][M];
		for(int init1 = 0;init1<N;init1++) {
			line = br.readLine().trim().split(" ");
			for(int init2 = 0;init2<M;init2++) {
				board[init1][init2] = Integer.parseInt(line[init2]);
			}
		}
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				int tns1 = board[i][j] + (i>0?board[i-1][j]:0);
				int tns2 = board[i][j] + (j>0?board[i][j-1]:0);
				int tns3 = board[i][j] + (i>0&&j>0?board[i-1][j-1]:0);
				if(board[i][j]<tns1) board[i][j] = tns1;
				if(board[i][j]<tns2) board[i][j] = tns2;
				if(board[i][j]<tns3) board[i][j] = tns3;
			}
		}
		System.out.println(board[N-1][M-1]);
	}
}