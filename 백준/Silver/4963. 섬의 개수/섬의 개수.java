import java.util.*;
import java.io.*;

public class Main{
	public static void visitDfs(boolean[][] visitBoard, boolean[][] board, int[] loc, int w, int h) {
		if(loc[1]>0 && board[loc[1]-1][loc[0]] && !visitBoard[loc[1]-1][loc[0]]) {
			visitBoard[loc[1]-1][loc[0]] = true;
			int[] nextLoc = {loc[0], loc[1]-1};
			visitDfs(visitBoard, board, nextLoc, w, h);
		}
		if(loc[1]<h-1 && board[loc[1]+1][loc[0]] && !visitBoard[loc[1]+1][loc[0]]) {
			visitBoard[loc[1]+1][loc[0]] = true;
			int[] nextLoc = {loc[0], loc[1]+1};
			visitDfs(visitBoard, board, nextLoc, w, h);
		}
		if(loc[0]>0 && board[loc[1]][loc[0]-1] && !visitBoard[loc[1]][loc[0]-1]) {
			visitBoard[loc[1]][loc[0]-1] = true;
			int[] nextLoc = {loc[0]-1, loc[1]};
			visitDfs(visitBoard, board, nextLoc, w, h);
		}
		if(loc[0]<w-1 && board[loc[1]][loc[0]+1] && !visitBoard[loc[1]][loc[0]+1]) {
			visitBoard[loc[1]][loc[0]+1] = true;
			int[] nextLoc = {loc[0]+1, loc[1]};
			visitDfs(visitBoard, board, nextLoc, w, h);
		}
		if(loc[1]>0 && loc[0]>0 && board[loc[1]-1][loc[0]-1] && !visitBoard[loc[1]-1][loc[0]-1]) {
			visitBoard[loc[1]-1][loc[0]-1] = true;
			int[] nextLoc = {loc[0]-1, loc[1]-1};
			visitDfs(visitBoard, board, nextLoc, w, h);
		}

		if(loc[1]<h-1 && loc[0]>0 && board[loc[1]+1][loc[0]-1] && !visitBoard[loc[1]+1][loc[0]-1]) {
			visitBoard[loc[1]+1][loc[0]-1] = true;
			int[] nextLoc = {loc[0]-1, loc[1]+1};
			visitDfs(visitBoard, board, nextLoc, w, h);
		}

		if(loc[1]>0 && loc[0]<w-1 && board[loc[1]-1][loc[0]+1] && !visitBoard[loc[1]-1][loc[0]+1]) {
			visitBoard[loc[1]-1][loc[0]+1] = true;
			int[] nextLoc = {loc[0]+1, loc[1]-1};
			visitDfs(visitBoard, board, nextLoc, w, h);
		}

		if(loc[1]<h-1 && loc[0]<w-1 && board[loc[1]+1][loc[0]+1] && !visitBoard[loc[1]+1][loc[0]+1]) {
			visitBoard[loc[1]+1][loc[0]+1] = true;
			int[] nextLoc = {loc[0]+1, loc[1]+1};
			visitDfs(visitBoard, board, nextLoc, w, h);
		}
	}
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split(" ");
        int w = Integer.parseInt(line[0]);
        int h = Integer.parseInt(line[1]);
        
        while(w != 0 && h != 0) {
        	boolean[][] board = new boolean[h][w];
        	boolean[][] visitedBoard = new boolean[h][w];
        	for(int cycle = 0;cycle<h;cycle++) {
        		line = br.readLine().trim().split(" ");
        		for(int cycle_col = 0;cycle_col < w;cycle_col++) {
        			board[cycle][cycle_col] = Integer.parseInt(line[cycle_col])==1;
        		}
        	}
        	int count = 0;
        	for(int tns_h = 0;tns_h<h;tns_h++) {
        		for(int tns_w = 0;tns_w < w;tns_w++) {
        			if(board[tns_h][tns_w] && !visitedBoard[tns_h][tns_w]) {
        				visitedBoard[tns_h][tns_w] = true;
        				count++;
        				int[] loc = {tns_w, tns_h};
        				visitDfs(visitedBoard, board, loc, w, h);
        			}
        		}
        	}
        	System.out.println(count);
        	line = br.readLine().trim().split(" ");
            w = Integer.parseInt(line[0]);
            h = Integer.parseInt(line[1]);
        }
    }
}