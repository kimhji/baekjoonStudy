import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		char[][] board = new char[N][N];
		for(int i = 0;i<N;i++) {
			board[i] = br.readLine().trim().toCharArray();
		}
		System.out.print(findAreaWithNormal(board, N) + " "+ findAreaWithWeak(board, N));
	}
	
	public static int findAreaWithWeak(char[][] board, int N) {
		boolean[][] weak = new boolean[N][N];
		Set<Integer[]> bag = new HashSet<Integer[]>();
		int num = 0;
		boolean isRedOrGreen = false;
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				if(weak[i][j]) continue;
				Integer[] loc = {i,j};
				bag.add(loc);
				num++;
				if(board[i][j] == 'B') {
					isRedOrGreen = false;
				}
				else {
					isRedOrGreen = true;
				}
				while(!bag.isEmpty()) {
					Integer[][] locs = bag.toArray(new Integer[0][]);
					bag.clear();
					for(Integer[] locData:locs) {
						if(locData[0]+1<N&&!weak[locData[0]+1][locData[1]]&&(isRedOrGreen && board[locData[0]+1][locData[1]] != 'B' || 
								!isRedOrGreen && board[locData[0]+1][locData[1]] == 'B')) {
							Integer[] tnsLoc = {locData[0]+1,locData[1]};
							weak[tnsLoc[0]][tnsLoc[1]] = true;
							bag.add(tnsLoc);
						}

						if(locData[1]+1<N&&!weak[locData[0]][locData[1]+1]&&(isRedOrGreen && board[locData[0]][locData[1]+1] != 'B' || 
								!isRedOrGreen && board[locData[0]][locData[1]+1] == 'B')) {
							Integer[] tnsLoc = {locData[0],locData[1]+1};
							weak[tnsLoc[0]][tnsLoc[1]] = true;
							bag.add(tnsLoc);
						}
						if(locData[0]>0&&!weak[locData[0]-1][locData[1]]&&(isRedOrGreen && board[locData[0]-1][locData[1]] != 'B' || 
								!isRedOrGreen && board[locData[0]-1][locData[1]] == 'B')) {
							Integer[] tnsLoc = {locData[0]-1,locData[1]};
							weak[tnsLoc[0]][tnsLoc[1]] = true;
							bag.add(tnsLoc);
						}

						if(locData[1]>0&&!weak[locData[0]][locData[1]-1]&&(isRedOrGreen && board[locData[0]][locData[1]-1] != 'B' || 
								!isRedOrGreen && board[locData[0]][locData[1]-1] == 'B')) {
							Integer[] tnsLoc = {locData[0],locData[1]-1};
							weak[tnsLoc[0]][tnsLoc[1]] = true;
							bag.add(tnsLoc);
						}
					}
				}
			}
		}
		return num;
	}
	
	public static int findAreaWithNormal(char[][] board, int N) {
		boolean[][] normal = new boolean[N][N];
		Set<Integer[]> bag = new HashSet<Integer[]>();
		int num = 0;
		char curData = ' ';
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<N;j++) {
				if(normal[i][j]) continue;
				Integer[] loc = {i,j};
				bag.add(loc);
				num++;
				curData = board[i][j];
				while(!bag.isEmpty()) {
					Integer[][] locs = bag.toArray(new Integer[0][]);
					bag.clear();
					for(Integer[] locData:locs) {
						if(locData[0]+1<N&&!normal[locData[0]+1][locData[1]]&&board[locData[0]+1][locData[1]] == curData) {
							Integer[] tnsLoc = {locData[0]+1,locData[1]};
							normal[tnsLoc[0]][tnsLoc[1]] = true;
							bag.add(tnsLoc);
						}

						if(locData[1]+1<N&&!normal[locData[0]][locData[1]+1]&&board[locData[0]][locData[1]+1] == curData) {
							Integer[] tnsLoc = {locData[0],locData[1]+1};
							normal[tnsLoc[0]][tnsLoc[1]] = true;
							bag.add(tnsLoc);
						}
						if(locData[0]>0&&!normal[locData[0]-1][locData[1]]&&board[locData[0]-1][locData[1]] == curData) {
							Integer[] tnsLoc = {locData[0]-1,locData[1]};
							normal[tnsLoc[0]][tnsLoc[1]] = true;
							bag.add(tnsLoc);
						}

						if(locData[1]>0&&!normal[locData[0]][locData[1]-1]&&board[locData[0]][locData[1]-1] == curData) {
							Integer[] tnsLoc = {locData[0],locData[1]-1};
							normal[tnsLoc[0]][tnsLoc[1]] = true;
							bag.add(tnsLoc);
						}
					}
				}
			}
		}
		return num;
	}
}