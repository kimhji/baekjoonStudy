
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        List<Edge> edges = new LinkedList<Edge>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        Node[] nodes = new Node[N];
        List<Edge> usedEdges = new ArrayList<Edge>();

        for (int i = 0; i < N; i++) {
            nodes[i] = new Node(i, nodes);
        }

        for (int i = 0; i < M; i++) {
            line = br.readLine().trim().split(" ");
            int one = Integer.parseInt(line[0]) - 1;
            int two = Integer.parseInt(line[1]) - 1;
            int value = Integer.parseInt(line[2]);
            edges.add(new Edge(one, two, value));
        }
        Collections.sort(edges);

        for (Edge edge : edges) {
            if (usedEdges.size() >= N - 1) {
                break;
            }
            int rootOne = nodes[edge.one].getRoot();
            int rootTwo = nodes[edge.two].getRoot();
            if (rootOne == rootTwo) {
                continue;
            }
            nodes[rootTwo].parent = nodes[rootOne];
            usedEdges.add(edge);
        }

        int result = 0;
        for (Edge edge : usedEdges) {
            result += edge.value;
        }
        if (usedEdges.size() > 0) {
            result -= usedEdges.get(usedEdges.size() - 1).value;
        }

        System.out.println(result);
    }
}

class Edge implements Comparable<Edge> {

    int value;
    int one;
    int two;

    Edge(int one, int two, int value) {
        this.value = value;
        this.one = one;
        this.two = two;
    }

    @Override
    public int compareTo(Edge edge) {
        return this.value - edge.value;
    }

}

class Node {

    Node[] friends = null;
    Node parent = null;
    int number;

    Node(int n, Node[] nodes) {
        this.number = n;
        this.friends = nodes;
    }

    int getRoot() {
        if (this.parent == null) {
            return this.number;
        }
        int idx = this.parent.getRoot();
        this.parent = this.friends[idx];
        return idx;
    }
}
