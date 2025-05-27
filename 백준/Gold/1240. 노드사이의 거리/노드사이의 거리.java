import java.util.*;
import java.io.*;

class edge{
	int one;
	int two;
	int val;
	
	edge(int one, int two, int val){
		this.one = one;
		this.two = two;
		this.val = val;
	}
}

class Node{
	LinkedList<edge> edges;
	Node(){
		edges=new LinkedList<edge>();
	}
}

class CurVal{
	int value;
	int loc;
	CurVal(int value, int loc){
		this.value = value;
		this.loc = loc;
	}
}

public class Main{	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().trim().split(" ");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		edge[] edges = new edge[N-1]; 
		Node[] nodes= new Node[N];
		for(int init = 0;init<N-1;init++) {
			line = br.readLine().trim().split(" ");
			edges[init] = new edge(Integer.parseInt(line[0])-1, Integer.parseInt(line[1])-1, Integer.parseInt(line[2]));
			if(nodes[edges[init].one]==null) {
				nodes[edges[init].one] = new Node();
			}
			nodes[edges[init].one].edges.add(edges[init]);
			if(nodes[edges[init].two]==null) {
				nodes[edges[init].two] = new Node();
			}
			nodes[edges[init].two].edges.add(edges[init]);
		}
		for(int test = 0;test<M;test++) {
			line = br.readLine().trim().split(" ");
			int one = Integer.parseInt(line[0])-1;
			int two = Integer.parseInt(line[1])-1;
			boolean[] visited = new boolean[N];
			visited[one] = true;
			
			List<CurVal> bag = new LinkedList<CurVal>();
			bag.add(new CurVal(0,one));
			int minV = -1;
			while(bag.size() != 0) {
				List<CurVal> nextBag = new LinkedList<CurVal>();
				for(CurVal find : bag) {
					for(edge data:nodes[find.loc].edges) {
						if(data.one == find.loc&&!visited[data.two]) {
							visited[data.two] = true;
							if(data.two == two) {
								if(minV < 0||find.value+data.val<minV) {
									minV = find.value+data.val;
								}
							}
							else {
								nextBag.add(new CurVal(find.value+data.val, data.two));
							}
						}
						else if(data.two == find.loc&&!visited[data.one]) {
							visited[data.one] = true;
							if(data.one == two) {
								if(minV < 0||find.value+data.val<minV) {
									minV = find.value+data.val;
								}
							}
							else {
								nextBag.add(new CurVal(find.value+data.val, data.one));
							}
						}
					}
				}
				bag = nextBag;
			}
			System.out.println(minV);
		}
	}
}