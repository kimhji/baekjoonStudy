import java.io.*;
import java.util.*;

class Node{
	public Node parent;
	public int cur;
	public Queue<Node> near = new LinkedList<Node>();
	public void node(Node parent, int data) {
		this.parent = parent;
		this.cur = data;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public void dfs() {
		for(Node child:near) {
			if(child==parent) continue;
			child.parent = this;
			child.dfs();
		}
	}
}

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		Node[] datas = new Node[N];
		Queue<int[]> edges = new LinkedList<int[]>();
		
		for(int i = 0;i<N;i++) {
			datas[i] = new Node();
			datas[i].node(null, i+1);
		}
		for(int i = 0;i<N-1;i++) {
			String[] line = br.readLine().trim().split(" ");
			int[] edge = {Integer.parseInt(line[0]),Integer.parseInt(line[1])};
			edges.add(edge);
			datas[edge[0]-1].near.add(datas[edge[1]-1]);
			datas[edge[1]-1].near.add(datas[edge[0]-1]);
		}
		int visited = 1;
		datas[0].dfs();
		for(Node data:datas) {
			if(data.parent == null) continue;
			System.out.println(data.parent.cur);
		}
	}
	
}