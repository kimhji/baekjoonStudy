import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
		String[] line = br.readLine().trim().split(" ");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		int[][] board = new int[N][M];
		for(int i = 0;i<N;i++) {
			line = br.readLine().trim().split("");
			for(int j = 0;j<M;j++) {
				board[i][j] = Integer.parseInt(line[j]);
			}
		}
		int max = 0;
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				int size = 1;
				while(i+size<N&&j+size<M) {
					if(board[i+size][j+size] == board[i][j] && board[i+size][j] == board[i][j]
							&& board[i][j+size] == board[i][j]) {
						if(max<size) {
							max = size;
						}
					}
					size++;
				}
			}
		}
		System.out.print((max+1)*(max+1));
    }
}
