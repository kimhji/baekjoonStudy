import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] argStr = br.readLine().trim().split(" ");
        int N = Integer.parseInt(argStr[0]);
        int M = Integer.parseInt(argStr[1]);
        Node[] nodes = new Node[N];
        for(int i = 0;i<N;i++){
            nodes[i] = new Node();
        }
        int start = Integer.parseInt(br.readLine().trim())-1;
        for(int i = 0;i<M;i++){
            argStr = br.readLine().trim().split(" ");
            Edge edge = new Edge(nodes[Integer.parseInt(argStr[0])-1],nodes[Integer.parseInt(argStr[1])-1],Integer.parseInt(argStr[2]));
            edge.start.edges.add(edge);
        }
        
        nodes[start].value = 0;
        PriorityQueue<Node> bag = new PriorityQueue<>(Comparator.comparingLong(n->n.value));
        bag.add(nodes[start]);
        while(!bag.isEmpty()){
            Node node = bag.poll();

            node.visit(bag);
        }

        for(Node node:nodes){
            System.out.println(node.value == Long.MAX_VALUE?"INF":node.value);
        }
    }
}

class Node{
    long value = Long.MAX_VALUE;
    LinkedList<Edge> edges = new LinkedList<Edge>();
    void visit(PriorityQueue<Node> nextBag){
        for(Edge edge: this.edges){
            if(edge.end.value <= this.value+edge.value) continue;
             edge.end.value = this.value+edge.value;
             nextBag.add(edge.end);
        }
    }
}
class Edge{
    Node start;
    Node end;
    int value;
    Edge(Node start, Node end, int value){
        this.start = start;
        this.end = end;
        this.value = value;
    }
}