import java.util.*;
import java.io.*;

public class Main{
	public static boolean isNearEmpty(boolean[][] board, int N, int[] loc) {
		if(loc[0] > 0 && loc[1] > 0 && !board[loc[0]-1][loc[1]-1]) return true;
		if(loc[0] > 0 && loc[1] < N-1 && !board[loc[0]-1][loc[1]+1]) return true;
		if(loc[0] < N-1 && loc[1] > 0 && !board[loc[0]+1][loc[1]-1]) return true;
		if(loc[0] < N-1 && loc[1] < N-1 && !board[loc[0]+1][loc[1]+1]) return true;
		if(loc[0] > 0 && !board[loc[0]-1][loc[1]]) return true;
		if(loc[0] < N-1 && !board[loc[0]+1][loc[1]]) return true;
		if(loc[1] > 0 && !board[loc[0]][loc[1]-1]) return true;
		if(loc[1] < N-1 && !board[loc[0]][loc[1]+1]) return true;
		return false;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] line = br.readLine().trim().split(" ");
		int N = Integer.parseInt(line[0]);
		int QN = Integer.parseInt(line[1]);
		
		boolean[][] board = new boolean[3][3];
		int[] king = new int[2];
		line = br.readLine().trim().split(" ");
		king[0] = Integer.parseInt(line[0])-1;
		king[1] = Integer.parseInt(line[1])-1;
		
		if(king[0] == 0) {
			board[0][0] = true;
			board[0][1] = true;
			board[0][2] = true;
		}
		if(king[0]==N-1) {
			board[2][0] = true;
			board[2][1] = true;
			board[2][2] = true;
		}

		if(king[1] == 0) {
			board[0][0] = true;
			board[1][0] = true;
			board[2][0] = true;
		}
		if(king[1]==N-1) {
			board[0][2] = true;
			board[1][2] = true;
			board[2][2] = true;
		}
		
		for(int init = 0;init<QN;init++) {
			int r,c = 0;
			line = br.readLine().trim().split(" ");
			r = Integer.parseInt(line[0])-1;
			c = Integer.parseInt(line[1])-1;
			
			if(Math.abs(r-king[0])<2) {
				for(int tnsc = 0;tnsc<3;tnsc++) {
					board[r-king[0]+1][tnsc] = true;
				}
			}
			if(Math.abs(c-king[1])<2) {
				for(int tnsr = 0;tnsr<3;tnsr++) {
					board[tnsr][c-king[1]+1] = true;
				}
			}
			int crossDist = Math.abs(Math.abs(c-king[1])-Math.abs(r-king[0]));
			int dir_r = king[0]-r;
			int dir_c = king[1]-c;
			switch(crossDist) {
			case 0:
				if(dir_c*dir_r>0) {
					board[0][0] = true;
					board[1][1] = true;
					board[2][2] = true;
				}
				else {
					board[0][2] = true;
					board[1][1] = true;
					board[2][0] = true;
				}
				break;
			case 1:
				if(dir_c*dir_r>0) {
					if(dir_c>0 && Math.abs(dir_c)<Math.abs(dir_r)||dir_c<0 && Math.abs(dir_c)>Math.abs(dir_r)) {
						board[0][1] = true;
						board[1][2] = true;
					}
					else {
						board[1][0] = true;
						board[2][1] = true;
					}
				}
				else {
					if(dir_c>0&&Math.abs(dir_c)<Math.abs(dir_r) || dir_c<0&&Math.abs(dir_c)>Math.abs(dir_r)) {
						board[1][2] = true;
						board[2][1] = true;
					}
					else {
						board[0][1] = true;
						board[1][0] = true;
					}
				}
				break;
			case 2:
				if(Math.abs(r - (king[0]-1))==Math.abs(c-(king[1]-1))) {
					board[0][0] = true;
				}
				if(Math.abs(r - (king[0]+1))==Math.abs(c-(king[1]-1))) {
					board[2][0] = true;
				}
				if(Math.abs(r - (king[0]-1))==Math.abs(c-(king[1]+1))) {
					board[0][2] = true;
				}
				if(Math.abs(r - (king[0]+1))==Math.abs(c-(king[1]+1))) {
					board[2][2] = true;
				}
			}
		
		}
		int[] loc = {1,1};
		boolean nearEmpty = isNearEmpty(board, 3, loc);
		if(board[loc[0]][loc[1]]) {
			if(nearEmpty) System.out.print("CHECK");
			else System.out.print("CHECKMATE");
		}
		else if(!nearEmpty) System.out.print("STALEMATE");
		else System.out.print("NONE");
	}
}