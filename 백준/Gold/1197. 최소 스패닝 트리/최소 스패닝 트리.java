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
            nodes[i] =  new Node();
        }
        for(int j = 0;j<M;j++){
            argStr = br.readLine().trim().split(" ");
            int one = Integer.parseInt(argStr[0])-1;
            int two = Integer.parseInt(argStr[1])-1;
            int value = Integer.parseInt(argStr[2]);
            Edge tnsEdge = new Edge(nodes[one], nodes[two], value);
            nodes[one].edges.add(tnsEdge);
            nodes[two].edges.add(tnsEdge);
        }
        PriorityQueue<Edge> mstQueue = new PriorityQueue<Edge>();
        int visited = 1;
        int result = 0;
        nodes[0].isVisited = true;
        for(Edge edge:nodes[0].edges){
            mstQueue.add(edge);
        }
        while(visited<N){
            Edge popEdge = mstQueue.poll();
            if(popEdge.one.isVisited && popEdge.two.isVisited) continue;
            Node theOther = popEdge.one;
            if(popEdge.one.isVisited){
                theOther = popEdge.two;
            }
            theOther.isVisited = true;
            result += popEdge.value;
            for(Edge edge: theOther.edges){
                if(edge.one.isVisited && edge.two.isVisited) continue;
                mstQueue.add(edge);
            }
            visited++;
        }
        System.out.println(result);
    }
}

class Node{
    List<Edge> edges = new LinkedList<Edge>();
    boolean isVisited = false;
}

class Edge implements Comparable<Edge>{
    Node one;
    Node two;
    int value;

    Edge(Node one, Node two, int value){
        this.one = one;
        this.two = two;
        this.value = value;
    }

    @Override
    public int compareTo(Edge data){
        return this.value - data.value;
    }
}