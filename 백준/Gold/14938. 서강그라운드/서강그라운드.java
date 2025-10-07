import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().trim().split(" ");
        int N = Integer.parseInt(strs[0]);
        int M = Integer.parseInt(strs[1]);
        int R = Integer.parseInt(strs[2]);
        Node[] areas = new Node[N];
        strs = br.readLine().trim().split(" ");
        for(int i = 0;i<N;i++){
            areas[i] = new Node(i,Integer.parseInt(strs[i]));
        }
        for(int i = 0;i<R;i++){
            strs = br.readLine().trim().split(" ");
            int idx_1 = Integer.parseInt(strs[0])-1;
            int idx_2 = Integer.parseInt(strs[1])-1;
            int val = Integer.parseInt(strs[2]);
            Edge edge = new Edge(areas[idx_1], areas[idx_2], val);
            areas[idx_1].edges.add(edge);
            areas[idx_2].edges.add(edge);
        }
        int result = 0;
        for(int i = 0;i<N;i++){
            int[] visited = new int[N];
            for(int j = 0;j<N;j++){
                visited[j] = -1;
            }
            visited[i] = 0;
            dfs(N, M, areas, visited, i);
            int tns = 0;
            for(int j = 0;j<N;j++){
                if(visited[j]>=0) tns += areas[j].itemNum;
            }
            if(tns>result) result = tns;
        }
        System.out.println(result);
    }
    public static void dfs(int N, int M, Node[] areas, int[] visited, int idx){
        for(Edge edge : areas[idx].edges){
            Node theother = (edge.one == areas[idx]?edge.two:edge.one);
            if(M < visited[idx]+edge.value) continue;
            if(visited[theother.idx] >= 0 && 
            visited[theother.idx] < visited[idx]+edge.value) continue;
            visited[theother.idx] = visited[idx]+edge.value;
            dfs(N, M, areas, visited, theother.idx);
        }
    }
}

class Node{
    int itemNum;
    int idx;
    List<Edge> edges = new LinkedList<Edge>();
    Node(int idx, int itemNum){
        this.idx = idx;
        this.itemNum = itemNum;
    }
}
class Edge{
    Node one;
    Node two;
    int value;
    Edge(Node one, Node two, int val){
        this.one = one;
        this.two = two;
        this.value = val;
    }
}