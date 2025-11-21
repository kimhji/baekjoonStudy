import java.io.*;
import java.util.*;

public class Main {

    static void dfs(int here, int[] a, boolean[] visited) {
        if (visited[here]) return;
        visited[here] = true;
        dfs(a[here], a, visited);
    }

    static void dfsAll(int[] a) {
        int count = 0;
        boolean[] visited = new boolean[a.length];

        for (int i = 0; i < a.length; i++) {
            if (!visited[i]) {
                dfs(i, a, visited);
                count++;
            }
        }

        System.out.println((count == 1) ? 0 : count);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        dfsAll(a);
    }
}
