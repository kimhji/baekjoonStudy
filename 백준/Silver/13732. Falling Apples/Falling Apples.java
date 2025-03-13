import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int R, C;
		String[] line = br.readLine().trim().split(" ");
		R = Integer.parseInt(line[0]);
		C = Integer.parseInt(line[1]);
		
		char[][] beforeBoard = new char[R][C];
		char[][] afterBoard = new char[R][C];
		int[] lastEmpty = new int[C];
		
		for(int init = 0;init<R;init++) {
			beforeBoard[init] = br.readLine().trim().toCharArray();
			afterBoard[init] = ".".repeat(C).toCharArray();
		}
		for(int cInit = 0;cInit<C;cInit++) {
			lastEmpty[cInit] = R-1;
		}
		
		for(int r = R-1;r>=0;r--) {
			for(int c=0;c<C;c++) {
				if(beforeBoard[r][c] == '#') {
					afterBoard[r][c] = '#';
					lastEmpty[c] = r-1;
					continue;
				}
				if(beforeBoard[r][c] == '.') continue;
				int afterR = r;
				
				afterBoard[lastEmpty[c]][c] = 'a';
				lastEmpty[c]--;
			}
		}
		for(int p = 0;p<R;p++) {
			for(int w = 0;w<C;w++) {
				System.out.print(afterBoard[p][w]);
			}
			System.out.println();
		}
	}
}