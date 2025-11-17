import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().trim().split(" ");
        int N = Integer.parseInt(data[0]);
        int M = Integer.parseInt(data[1]);

        int[] parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        int result = 0;
        for (int i = 0; i < M; i++) {
            data = br.readLine().trim().split(" ");
            int start = Integer.parseInt(data[0]);
            int end = Integer.parseInt(data[1]);

            if (findParent(parent, start) == findParent(parent, end)) {
                result = i + 1;
                break;
            }
            parent[parent[end]] = parent[start];
        }

        System.out.println(result);
    }

    public static int findParent(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent, parent[x]);
        }
        return parent[x];
    }
}
