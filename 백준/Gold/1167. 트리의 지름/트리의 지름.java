import java.util.*;
import java.io.*;

class Edge{
	TreeNode start;
	TreeNode end;
	int distance;
}
class TreeNode{
	int val;
	TreeNode[] nodes;
	LinkedList<Edge> edges = new LinkedList<Edge>();
	TreeNode(TreeNode[] nodes){
		this.nodes = nodes;
	}
	void init(String line){
		String[] values = line.trim().split(" ");
		int val = Integer.parseInt(values[0])-1;
		nodes[val].val = val;
		for(int i = 1;i<values.length-1;i+=2) {
			Edge edge = new Edge();
			edge.start = nodes[val];
			edge.end = nodes[Integer.parseInt(values[i])-1];
			edge.distance = Integer.parseInt(values[i+1]);
			nodes[val].edges.add(edge);
		}
	}
}

public class Main {
	
	public static TreeNode[] node;

	public static int findDist(int start, int N, boolean getDist) {
		int[] dist = new int[N];
		LinkedList<Integer> bag = new LinkedList<Integer>();
		bag.add(start);
		for(int i = 0;i<N;i++) {
			dist[i] = -1;
		}
		dist[start] = 0;
		while(!bag.isEmpty()) {
			LinkedList<Integer> nextBag = new LinkedList<Integer>();
			for(Integer next: bag) {
				for(Edge edge: node[next].edges) {
					if(dist[edge.end.val]<0 || edge.distance + dist[next] < dist[edge.end.val]) {
						dist[edge.end.val] = edge.distance + dist[next];
						nextBag.add(edge.end.val);
					}
				}
			}
			bag = nextBag;
		}
		int result = 0;
		for(int i=1;i<N;i++) {
			if(dist[result] < dist[i]) result = i;
		}
		return getDist?dist[result]:result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());
		node = new TreeNode[N];
		for(int init = 0;init<N;init++) {
			node[init] = new TreeNode(node);
		}
		for(int init = 0;init<N;init++) {
			node[init].init(br.readLine());
		}
		int root = findDist(0, N, false);
		int result = findDist(root, N, true);
		System.out.println(result);
	}

}
