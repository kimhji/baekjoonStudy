import java.util.*;
import java.io.*;

public class Main{
	static int N, M;
	static int C = 3;
	public static int near3(int r, int c, int[][] board) {
		int result = 0;
		int tnsR;
		if(r>0 && r<N-1&&c>0) {
			tnsR = board[r][c]+board[r-1][c]+board[r+1][c]+board[r][c-1];
			if(result < tnsR) result = tnsR;
		}
		if(r>0 && c<M-1&&c>0) {
			tnsR = board[r][c]+board[r-1][c]+board[r][c+1]+board[r][c-1];
			if(result < tnsR) result = tnsR;
		}
		if(r>0 && r<N-1&& c<M-1) {
			tnsR = board[r][c]+board[r-1][c]+board[r+1][c]+board[r][c+1];
			if(result < tnsR) result = tnsR;
		}
		if(c>0 && r<N-1&&c<M-1) {
			tnsR = board[r][c]+board[r][c-1]+board[r+1][c]+board[r][c+1];
			if(result < tnsR) result = tnsR;
		}
		return result;
	}
	
	public static int findMaxNear(int r, int c, int[][] board, int value, int count) {
		int result = value;
		if(r>0 && board[r-1][c] > 0) {
			int tnsV = value + board[r-1][c];
			if(count == C) {
				if(result < tnsV) result = tnsV;
			}
			else {
				board[r-1][c] = 0;
				int tns = findMaxNear(r-1,c,board, tnsV, count+1);
				board[r-1][c] = tnsV - value;
				if(result < tns) result = tns;
			}
		}
		if(r<N-1 && board[r+1][c] > 0) {
			int tnsV = value + board[r+1][c];
			if(count == C) {
				if(result < tnsV) result = tnsV;
			}
			else {
				board[r+1][c] = 0;
				int tns = findMaxNear(r+1,c,board, tnsV, count+1);
				board[r+1][c] = tnsV - value;
				if(result < tns) result = tns;
			}
		}
		if(c>0 && board[r][c-1] > 0) {
			int tnsV = value + board[r][c-1];
			if(count == C) {
				if(result < tnsV) result = tnsV;
			}
			else {
				board[r][c-1] = 0;
				int tns = findMaxNear(r,c-1,board, tnsV, count+1);
				board[r][c-1] = tnsV - value;
				if(result < tns) result = tns;
			}
		}
		if(c<M-1 && board[r][c+1] > 0) {
			int tnsV = value + board[r][c+1];
			if(count == C) {
				if(result < tnsV) result = tnsV;
			}
			else {
				board[r][c+1] = 0;
				int tns = findMaxNear(r,c+1,board, tnsV, count+1);
				board[r][c+1] = tnsV - value;
				if(result < tns) result = tns;
			}
		}
		return result;
	}
	
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().trim().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		int [][] board = new int[N][M];
		for(int init = 0; init < N;init++) {
			line = br.readLine().trim().split(" ");
			for(int iC = 0;iC<M;iC++) {
				board[init][iC] = Integer.parseInt(line[iC]);
			}
		}
		int maxR = 0;
		int tnsR;
		int tnsV;
		for(int r = 0;r<N;r++) {
			for(int c = 0;c<M;c++) {
				tnsR = near3(r, c, board);
				if(tnsR > maxR) maxR = tnsR;
				tnsV = board[r][c];
				board[r][c] = 0;
				tnsR = findMaxNear(r, c, board, tnsV, 1);
				if(tnsR > maxR) maxR = tnsR;
				board[r][c] = tnsV;
			}
		}
		System.out.print(maxR);
	}
}