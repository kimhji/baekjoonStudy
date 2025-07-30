import java.io.*;
import java.util.*;


class Main{
	public static int countSafe(int[][] board, int N, int M) {
		int result = 0;
		for(int i = 0;i<N;i++) {
			for(int j= 0;j<M;j++) {
				if(board[i][j] == 0) result++;
			}
		}
		return result;
	}
	
	public static void spreadVirus(LinkedList<int[]> bag, int[][] board, int N, int M, int i, int j) {
		 if(i<N-1 && board[i+1][j] == 0) {
			 bag.add(new int[]{i+1, j});
			 board[i+1][j] = 2;
		 }
		 if(j<M-1 && board[i][j+1] == 0) {
			 bag.add(new int[]{i, j+1});
			 board[i][j+1] = 2;
		 }
		 if(i>0 && board[i-1][j] == 0) {
			 bag.add(new int[]{i-1, j});
			 board[i-1][j] = 2;
		 }
		 if(j>0 && board[i][j-1] == 0) {
			 bag.add(new int[]{i, j-1});
			 board[i][j-1] = 2;
		 }
	}
	
	public static void repeatSpreadVirus(int[][] board, int N, int M) {
		LinkedList<int[]> bag = new LinkedList<int[]>();
		for(int y = 0;y<N;y++) {
			for(int x = 0;x<M;x++) {
				if(board[y][x] == 2) {
					bag.add(new int[] {y, x});
				}
			}
		}
		
		while(!bag.isEmpty()) {
			LinkedList<int[]> nextBag = new LinkedList<int[]>();
			for(int[] loc: bag) {
				spreadVirus(nextBag, board, N, M, loc[0], loc[1]);
			}
			bag = nextBag;
		}
	}
	
	public static int findMax(int[][] board, int N, int M) {
		int result = 0;
		ArrayList<int[]> data_0 = new ArrayList<int[]>();
		
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				if(board[i][j] == 0) {
					data_0.add(new int[] {i, j});
				}
			}
		}
		
		LinkedList<Integer> wall = new LinkedList<Integer>();
		Integer i = -1;
		while(true) {
			i++;
			if(i>=data_0.size()) {
				i = wall.pollLast();
				if(i == null) break;
				board[data_0.get(i)[0]][data_0.get(i)[1]] = 0;
				
				continue;
			}
			wall.addLast(i);
			board[data_0.get(i)[0]][data_0.get(i)[1]] = 1;
			
			if(wall.size() >= 3) {
				int[][] rep = replica(board, N, M);
				repeatSpreadVirus(rep, N, M);
				int tns = countSafe(rep, N, M);
				if(result < tns) result = tns;
				
				i = wall.pollLast();
				board[data_0.get(i)[0]][data_0.get(i)[1]] = 0;
			}
		}
		
		return result;
	}
	
	private static int[][] replica(int [][] board, int N, int M) {
		int[][] dest = new int[N][M];
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				dest[i][j] = board[i][j];
			}
		}
		return dest;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().trim().split(" ");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		
		int[][] board = new int[N][M];
		for(int i = 0;i<N;i++) {
			line = br.readLine().trim().split(" ");
			for(int j = 0;j<M;j++) {
				board[i][j] = Integer.parseInt(line[j]);
			}
		}
		int result = findMax(board, N, M);
		System.out.println(result);
	}
}
