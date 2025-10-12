import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] argStr = br.readLine().trim().split(" ");
        int N = Integer.parseInt(argStr[0]);
        int M = Integer.parseInt(argStr[1]);
        int K = Integer.parseInt(argStr[2])-1;
        Node[] nodes = new Node[N];
        int[] come = new int[N];
        int[] go = new int[N];
        for(int i = 0;i<N;i++){
            nodes[i] = new Node(i);
            come[i] = -1;
            go[i] = -1;
        }

        for(int i = 0;i<M;i++){
            argStr = br.readLine().trim().split(" ");
            int i_start = Integer.parseInt(argStr[0])-1;
            int i_end = Integer.parseInt(argStr[1])-1;
            int value = Integer.parseInt(argStr[2]);
            Edge edge = new Edge(nodes[i_end], value);
            Edge edge_r = new Edge(nodes[i_start], value);
            nodes[i_start].edges.add(edge);
            nodes[i_end].edges_reverse.add(edge_r);
        }
        dijstra(nodes[K], nodes, come, true);
        dijstra(nodes[K], nodes, go, false);
        int maxV = 0;
        for(int i = 0;i<N;i++){
            if(maxV < come[i]+go[i]){
                maxV = come[i]+go[i];
            }
        }
        System.out.println(maxV);
    }

    public static void dijstra(Node start, Node[] nodes, int[] value, boolean isReverse){
        value[start.idx] = 0;
        Set<Node> bag = new HashSet<Node>();
        bag.add(start);
        Set<Node> nextBag;
        while(bag.size()>0){
            nextBag = new HashSet<Node>();
            for(Node node: bag){
                List<Edge> edges = isReverse?node.edges_reverse:node.edges;
                for(Edge edge: edges){
                    int tns = edge.value+value[node.idx];
                    if(value[edge.end.idx] < 0 || value[edge.end.idx] > tns){
                        value[edge.end.idx] = tns;
                        nextBag.add(edge.end);
                    }
                }
            }
            bag = nextBag;
        }
    }
}

class Node{
    List<Edge> edges_reverse = new LinkedList<Edge>();
    List<Edge> edges = new LinkedList<Edge>();
    int idx;
    Node(int idx){
        this.idx = idx;
    }
}
class Edge {
    Node end;
    int value;

    Edge(Node end, int value){
        this.end = end;
        this.value = value;
    }
}