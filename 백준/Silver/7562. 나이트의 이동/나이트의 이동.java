import java.io.*;
import java.util.*;

class Main{	
	public static List<int[]> getNextLoc(int N, int[] curLoc){
		List<int[]> result = new LinkedList<int[]>();
		if(curLoc[0]+1<N && curLoc[1]+2<N) {
			result.add(new int[] {curLoc[0]+1, curLoc[1]+2});
		}
		if(curLoc[0]+2<N && curLoc[1]+1<N) {
			result.add(new int[] {curLoc[0]+2, curLoc[1]+1});
		}
		if(curLoc[0]>0 && curLoc[1]+2<N) {
			result.add(new int[] {curLoc[0]-1, curLoc[1]+2});
		}
		if(curLoc[0]>1 && curLoc[1]+1<N) {
			result.add(new int[] {curLoc[0]-2, curLoc[1]+1});
		}
		if(curLoc[0]>0 && curLoc[1]>1) {
			result.add(new int[] {curLoc[0]-1, curLoc[1]-2});
		}
		if(curLoc[0]>1 && curLoc[1]>0) {
			result.add(new int[] {curLoc[0]-2, curLoc[1]-1});
		}
		if(curLoc[0]+1<N && curLoc[1]>2) {
			result.add(new int[] {curLoc[0]+1, curLoc[1]-2});
		}
		if(curLoc[0]+2<N && curLoc[1]>0) {
			result.add(new int[] {curLoc[0]+2, curLoc[1]-1});
		}
		
		return result;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int t = 0;t<T;t++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[] curLoc = new int[2];
			int[] destLoc = new int[2];
			String[] line = br.readLine().trim().split(" ");
			curLoc[0] = Integer.parseInt(line[0]);
			curLoc[1] = Integer.parseInt(line[1]);
			line = br.readLine().trim().split(" ");
			destLoc[0] = Integer.parseInt(line[0]);
			destLoc[1] = Integer.parseInt(line[1]);
			boolean[][] board = new boolean[N][N];
			board[curLoc[0]][curLoc[1]] = true;
			boolean found = false;
			List<int[]> bag = new LinkedList<int[]>();
			bag.add(curLoc);
			List<int[]> nextBag;
			int result = 0;
			if(curLoc[0] == destLoc[0] && curLoc[1] == destLoc[1]) found = true;
			while(!bag.isEmpty() && !found) {
				nextBag = new LinkedList<int[]>();
				for(int[] loc : bag) {
					List<int[]> findLoc = getNextLoc(N, loc);
					for(int[] check: findLoc) {
						if(board[check[0]][check[1]]) continue;
						nextBag.add(check);
						board[check[0]][check[1]] = true;
						if(check[0] == destLoc[0] && check[1] == destLoc[1]) found = true;
					}
				}
				bag = nextBag;
				result++;
			}
			System.out.println(result);
		}
		
	}
}
