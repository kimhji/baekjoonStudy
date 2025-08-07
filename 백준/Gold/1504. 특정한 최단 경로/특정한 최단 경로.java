import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]  line = br.readLine().trim().split(" ");
        int N = Integer.parseInt(line[0]);
        int E = Integer.parseInt(line[1]);
        Node[] nodes = new Node[N];
        for(int i = 0;i<N;i++){
            nodes[i] = new Node(i);
        }
        for(int i = 0;i<E;i++){
            line = br.readLine().trim().split(" ");
            int v1 = Integer.parseInt(line[0])-1;
            int v2 = Integer.parseInt(line[1])-1;
            int cost = Integer.parseInt(line[2]);
            nodes[v1].edgeValue.put(v2, cost);
            nodes[v2].edgeValue.put(v1, cost);
        }
        line = br.readLine().trim().split(" ");
        int u = Integer.parseInt(line[0])-1;
        int v = Integer.parseInt(line[1])-1;

        int[] startToAnother = nodes[0].getNodeDist(nodes, N);
        int[] uToAnother = nodes[u].getNodeDist(nodes, N);
        int[] vToAnother = nodes[v].getNodeDist(nodes, N);

        int tns1 = startToAnother[u] + uToAnother[v] + vToAnother[N-1];
        int tns2 = startToAnother[v] + vToAnother[u] + uToAnother[N-1];
        if(startToAnother[u]<0 || uToAnother[v] <0 || vToAnother[N-1]<0) tns1 = -1;
        if(startToAnother[v]<0 || vToAnother[u] <0 || uToAnother[N-1]<0) tns2 = -1;
        if(tns1 < 0 && tns2 < -1){
            System.out.println(-1);
        }
        else if(tns1 < 0){
            System.out.println(tns1);
        }
        else if(tns2 < 0){
            System.out.println(tns2);
        }
        else{
            System.out.println(Math.min(tns1, tns2));
        }
    }
}
class Node{
    int value;
    Map<Integer, Integer> edgeValue = new HashMap<Integer, Integer>();
    Node(int value){
        this.value = value;
    }

    int[] getNodeDist(Node[] nodes, int N){
        if(this.value>=N) return null;
        int[] result = new int[N];
        for(int i = 0;i<N;i++){
            result[i] = -1;
        }
        result[this.value] = 0;
        Set<Integer> bag = new HashSet<Integer>();
        Set<Integer> nextBag;
        bag.add(this.value);
        while(!bag.isEmpty()){
            nextBag = new HashSet<Integer>();
            for(Integer nodeIdx: bag){
                for(Integer opposite: nodes[nodeIdx].edgeValue.keySet()){
                    if(result[opposite] < 0 || result[opposite] > result[nodeIdx] + nodes[nodeIdx].edgeValue.get(opposite)){
                        result[opposite] = result[nodeIdx] + nodes[nodeIdx].edgeValue.get(opposite);
                        nextBag.add(opposite);
                    }
                }
            }
            bag = nextBag;
        }

        return result;
    }
}
