import java.io.*;
import java.util.*;

public class Main{
	public static int dfs(int curV, int value, LinkedList<Integer>[] edges, int[] visited) {
		visited[curV] = value;
		
		for(Integer edgeData: edges[curV]) {
			if(visited[edgeData] == 0) {
				value = dfs(edgeData, value+1, edges, visited);
			}
		}
		
		return value;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().trim().split(" ");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		int R = Integer.parseInt(line[2]);
		LinkedList<Integer>[] edges = new LinkedList[N];
		for(int init = 0;init<N;init++) {
			edges[init] = new LinkedList<Integer>();
		}
		
		int[] result = new int[N];
		for(int i=0;i<M;i++) {
			line = br.readLine().strip().split(" ");
			int one = Integer.parseInt(line[0]) - 1;
			int two = Integer.parseInt(line[1]) - 1;
			
			edges[one].add(two);
			edges[two].add(one);
		}
		for(int i=0;i<N;i++) {
			Collections.sort(edges[i]);
		}
		dfs(R-1, 1, edges, result);
		
		for(int r: result) {
			System.out.println(r);
		}
	}
}

