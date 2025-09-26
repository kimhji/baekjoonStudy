import java.io.*;
import java.util.*;

public class Main {
    static List<List<int[]>> tree; 
    static int[] visited;      

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            tree.get(p).add(new int[]{c, w});
            tree.get(c).add(new int[]{p, w});
        }

        visited = new int[n + 1];
        Arrays.fill(visited, -1);
        visited[1] = 0;
        find(1, 0);

        int start = 1;
        for (int i = 1; i <= n; i++) {
            if (visited[i] > visited[start]) start = i;
        }

        visited = new int[n + 1];
        Arrays.fill(visited, -1);
        visited[start] = 0;
        find(start, 0);

        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            maxDist = Math.max(maxDist, visited[i]);
        }

        System.out.println(maxDist);
    }

    static void find(int node, int dist) {
        for (int[] next : tree.get(node)) {
            int nextNode = next[0];
            int weight = next[1];

            if (visited[nextNode] == -1) {
                visited[nextNode] = dist + weight;
                find(nextNode, visited[nextNode]);
            }
        }
    }
}
