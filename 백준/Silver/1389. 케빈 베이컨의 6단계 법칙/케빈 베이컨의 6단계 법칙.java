import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		
		int[] friendsBoard = new int[N+1];
		int[] resultBoard = new int[N+1];
		int[][] edges = new int[M][2];
		Set<Integer> bag = new HashSet<Integer>();
		Set<Integer> nextBag= new HashSet<Integer>();
		int minFriend = 1;
		
		for(int i = 0;i<M;i++) {
			line = br.readLine().split(" ");
			edges[i][0] = Integer.parseInt(line[0]);
			edges[i][1] = Integer.parseInt(line[1]);
		}
		
		for(int i=1;i<=N;i++) {
			initFriendsBoard(friendsBoard, N);
			bag.add(i);
			int step = 0;
			
			while(!bag.isEmpty()) {
				nextBag.clear();
				for(Integer item : bag) {
					if(friendsBoard[item]==-1) {
						friendsBoard[item] = step;
						addAbleFriends(nextBag, edges, item);
					}
				}
				step++;
				bag.clear();
				for(Integer item : nextBag) {
					bag.add(item);
				}
			}
			for(int j = 1;j<=N;j++) {
				resultBoard[i] += friendsBoard[j];
			}
			if(resultBoard[i]<resultBoard[minFriend]) {
				minFriend = i;
			}
		}
		System.out.print(minFriend);
	}
	public static void initFriendsBoard(int[] b, int N) {
		for(int i = 1;i<=N;i++) {
			b[i] = -1;
		}
	}
	
	public static void addAbleFriends(Set<Integer> bag, int[][] edges, int idx) {
		for(int[] edge:edges) {
			if(edge[1] == idx) {
				bag.add(edge[0]);
			}
			else if (edge[0]==idx) {
				bag.add(edge[1]);
			}
		}
	}
}
