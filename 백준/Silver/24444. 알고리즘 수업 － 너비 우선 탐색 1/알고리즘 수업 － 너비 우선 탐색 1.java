import java.util.*;
import java.io.*;

class Node{
	LinkedList<Integer> edge = new LinkedList<Integer>();
	int value;
	boolean visited = false;
	int count = 0;
	Node(int val){
		this.value = val;
	}
}

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int R = Integer.parseInt(line[2]);
        Node[] nodes = new Node[N];
        for(int init = 0;init<N;init++) {
        	nodes[init] = new Node(init+1);
        }
        
        for(int i = 0;i<M;i++) {
        	line = br.readLine().trim().split(" ");
        	int one = Integer.parseInt(line[0])-1;
        	int two = Integer.parseInt(line[1])-1;
        	
        	nodes[one].edge.add(two);
        	nodes[two].edge.add(one);
        }
        
        for(int i = 0; i < N; i++) {
            Collections.sort(nodes[i].edge);
        }
        
        LinkedList<Node> bag = new LinkedList<Node>();
        
        bag.add(nodes[R-1]);
        nodes[R-1].visited = true;
        int count = 1;
        while(!bag.isEmpty()) {
        	LinkedList<Node> nextBag = new LinkedList<Node>();
        	for(Node node:bag) {
        	    node.count = count++;
        		for(Integer oppoIdx:node.edge) {
        			if(nodes[oppoIdx].visited) continue;
        			nextBag.add(nodes[oppoIdx]);
        			nodes[oppoIdx].visited = true;
        		}
        	}
        	bag = nextBag;
        }
        for(Node node:nodes) {
        	System.out.println(node.count);
        }
    }
}