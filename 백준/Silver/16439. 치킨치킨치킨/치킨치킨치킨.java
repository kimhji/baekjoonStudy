import java.util.*;
import java.io.*;

public class Main{
	public static int[][] board;
	public static int maxV = 0;
	public static int N;
	public static int M;
	
	public static void dfs(int[] idx, int lastIdx, int count) {
		if(count == 3) {
			int tnsV = 0;
			for(int i = 0;i<N;i++) {
				if(board[i][idx[0]] > board[i][idx[1]]) {
					if(board[i][idx[0]] > board[i][idx[2]]) {
						tnsV += board[i][idx[0]];
					}
					else {
						tnsV += board[i][idx[2]];
					}
				}
				else {
					if(board[i][idx[1]] > board[i][idx[2]]) {
						tnsV += board[i][idx[1]];
					}
					else {
						tnsV += board[i][idx[2]];
					}
				}
			}
			if(tnsV>maxV) maxV = tnsV;
			return;
		}
		
		for(int cycle = lastIdx+1;cycle<M;cycle++) {
			idx[count] = cycle;
			dfs(idx, cycle, count+1);
		}
	}
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().trim().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        board = new int[N][M];
        for(int init = 0;init<N;init++) {
        	inputs = br.readLine().trim().split(" ");
        	for(int init2 = 0;init2<M;init2++) {
        		board[init][init2] = Integer.parseInt(inputs[init2]);
        	}
        }
        int[] idx = new int[3];
        dfs(idx, -1, 0);
        System.out.println(maxV);
    }
}