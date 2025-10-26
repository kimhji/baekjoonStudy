import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < T; i++) {
            String[] argStr = br.readLine().trim().split(" ");
            int N = Integer.parseInt(argStr[0]);
            int M = Integer.parseInt(argStr[1]);
            int W = Integer.parseInt(argStr[2]);

            Node[] nodes = new Node[N];
            for (int j = 0; j < N; j++) {
                nodes[j] = new Node(j);
            }

            List<Edge> edges = new ArrayList<>();

            // 도로 (양방향)
            for (int j = 0; j < M; j++) {
                argStr = br.readLine().trim().split(" ");
                int a = Integer.parseInt(argStr[0]) - 1;
                int b = Integer.parseInt(argStr[1]) - 1;
                int c = Integer.parseInt(argStr[2]);
                edges.add(new Edge(nodes[a], nodes[b], c));
                edges.add(new Edge(nodes[b], nodes[a], c));
            }

            // 웜홀 (단방향, 음수)
            for (int j = 0; j < W; j++) {
                argStr = br.readLine().trim().split(" ");
                int a = Integer.parseInt(argStr[0]) - 1;
                int b = Integer.parseInt(argStr[1]) - 1;
                int c = Integer.parseInt(argStr[2]);
                edges.add(new Edge(nodes[a], nodes[b], -c));
            }

            // 벨만-포드 실행
            boolean hasNegativeCycle = false;

            // dist를 N개 다 0으로 설정 → 모든 노드 출발점 취급
            int[] dist = new int[N];
            Arrays.fill(dist, 0);

            for (int k = 0; k < N - 1; k++) {
                for (Edge e : edges) {
                    if (dist[e.end.idx] > dist[e.start.idx] + e.dist) {
                        dist[e.end.idx] = dist[e.start.idx] + e.dist;
                    }
                }
            }

            for (Edge e : edges) {
                if (dist[e.end.idx] > dist[e.start.idx] + e.dist) {
                    hasNegativeCycle = true;
                    break;
                }
            }

            System.out.println(hasNegativeCycle ? "YES" : "NO");
        }
    }
}

class Node {
    int idx;
    Node(int idx) {
        this.idx = idx;
    }
}

class Edge {
    Node start;
    Node end;
    int dist;

    Edge(Node st, Node ed, int d) {
        start = st;
        end = ed;
        dist = d;
    }
}
