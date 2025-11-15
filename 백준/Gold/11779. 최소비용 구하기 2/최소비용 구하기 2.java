import java.io.*;
import java.util.*;

class Main {

    public static PathProcess[] costs;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());

        costs = new PathProcess[N];
        parent = new int[N];
        Arrays.fill(parent, -1);

        City[] cities = new City[N];
        for (int i = 0; i < N; i++) cities[i] = new City(i);

        for (int i = 0; i < M; i++) {
            String[] data = br.readLine().trim().split(" ");
            int start = Integer.parseInt(data[0]) - 1;
            int end = Integer.parseInt(data[1]) - 1;
            int value = Integer.parseInt(data[2]);
            cities[start].buses.add(new Edge(value, end));
        }

        String[] data = br.readLine().trim().split(" ");
        int startCity = Integer.parseInt(data[0]) - 1;
        int destCity = Integer.parseInt(data[1]) - 1;

        PriorityQueue<PathProcess> pq = new PriorityQueue<>();
        costs[startCity] = new PathProcess(startCity, 0);
        pq.add(costs[startCity]);

        while (!pq.isEmpty()) {
            PathProcess now = pq.poll();

            // -------- 추가된 핵심 1줄 --------
            if (now.value > costs[now.cityIdx].value) continue;

            int nowCity = now.cityIdx;

            for (Edge edge : cities[nowCity].buses) {
                int next = edge.goIdx;
                int newCost = now.value + edge.cost;

                if (costs[next] != null && costs[next].value <= newCost) continue;

                PathProcess newNode = new PathProcess(next, newCost);
                costs[next] = newNode;
                parent[next] = nowCity;
                pq.add(newNode);
            }
        }

        // ---- 출력 ----
        System.out.println(costs[destCity].value);

        List<Integer> path = new ArrayList<>();
        int cur = destCity;
        while (cur != -1) {
            path.add(cur + 1);
            cur = parent[cur];
        }
        Collections.reverse(path);

        System.out.println(path.size());
        for (int c : path) System.out.print(c + " ");
    }
}

class City {
    int number;
    List<Edge> buses = new LinkedList<>();
    City(int idx) { this.number = idx; }
}

class Edge {
    int cost, goIdx;
    Edge(int cost, int goIdx) {
        this.cost = cost; this.goIdx = goIdx;
    }
}

class PathProcess implements Comparable<PathProcess> {
    int cityIdx, value;

    PathProcess(int cityIdx, int value) {
        this.cityIdx = cityIdx;
        this.value = value;
    }

    @Override
    public int compareTo(PathProcess o) {
        return this.value - o.value;
    }
}
