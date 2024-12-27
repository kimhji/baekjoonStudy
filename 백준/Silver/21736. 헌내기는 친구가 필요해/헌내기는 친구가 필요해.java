import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static boolean [][] valueBoard;
	public static String [][] Board;
	public static int value = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		String[] line = sc.readLine().trim().split(" ");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		Board = new String[N][M];
		valueBoard = new boolean[N][M];
		Integer[] loc = {-1,-1};
		
		for(int i = 0;i<N;i++) {
			Board[i] = sc.readLine().trim().split("");
			for(int j = 0;j<M;j++) {
				if(Board[i][j].equals("I")) {
					loc[0] = i;
					loc[1] = j;
				}
			}
		}
		
		Vector<Integer[]> bag = new Vector<Integer[]>();
		bag.add(loc);
		BFS(bag, 1, N, M);
		System.out.print(value>0?value:"TT");
	}
	
	public static void BFS(Vector<Integer[]> bag, int length, int N, int M) {
		int nextLength = 0;
		Integer[] loc;
		Vector<Integer[]> nextBag = new Vector<Integer[]>();
		for(int c = 0;c<length;c++) {
			loc=bag.elementAt(c);
			if(valueBoard[loc[0]][loc[1]]) continue;
			if(Board[loc[0]][loc[1]].equals("P")) value++;
			valueBoard[loc[0]][loc[1]] = true;
			if(loc[1]>0 && !valueBoard[loc[0]][loc[1]-1] && !Board[loc[0]][loc[1]-1].equals("X")) {
				Integer[] tnsLoc = {loc[0], loc[1]-1};
				nextBag.add(tnsLoc);
				nextLength++;
			}
			if(loc[1]+1<M && !valueBoard[loc[0]][loc[1]+1] && !Board[loc[0]][loc[1]+1].equals("X")) {
				Integer[] tnsLoc = {loc[0], loc[1]+1};
				nextBag.add(tnsLoc);
				nextLength++;
			}

			if(loc[0]>0 && !valueBoard[loc[0]-1][loc[1]] && !Board[loc[0]-1][loc[1]].equals("X")) {
				Integer[] tnsLoc = {loc[0]-1, loc[1]};
				nextBag.add(tnsLoc);
				nextLength++;
			}
			if(loc[0]+1<N && !valueBoard[loc[0]+1][loc[1]] && !Board[loc[0]+1][loc[1]].equals("X")) {
				Integer[] tnsLoc = {loc[0]+1, loc[1]};
				nextBag.add(tnsLoc);
				nextLength++;
			}
		}
		if(nextLength == 0) return;
		BFS(nextBag, nextLength, N, M);
	}
}