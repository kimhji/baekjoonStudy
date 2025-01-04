import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		boolean[][] board = new boolean[N][N];
		String[] line;
		
		for(int i = 0;i<N;i++) {
			line = br.readLine().trim().split(" ");
			for(int j = 0;j<N;j++) {
				if(line[j].equals("1")) {
					board[i][j] = true;
				}
			}
		}
		
		Set<Integer> bag = new HashSet<Integer>();

		for(int t = 0;t<N;t++) {
		for(int i = 0;i<N;i++) {
			bag.add(i);
			while(!bag.isEmpty()) {
				Integer[] bagData =  bag.toArray(new Integer[0]);
				bag.clear();
				for(Integer loc:bagData) {				
					for(int j = 0;j<N;j++) {
						if(board[loc][j]) {
							for(int k = 0;k<N;k++) {
								if(board[j][k] && !board[loc][k]) {
									bag.add(j);
									board[loc][k] = true;
								}
								
							}
						}
					}
				}
			}
		}
		}
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				System.out.printf(board[i][j]?"1 ":"0 ");
			}
			
			System.out.print("\n");
		}
	}
}
