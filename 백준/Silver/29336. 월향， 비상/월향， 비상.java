import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        long currentQuality = 0;

        String[] qualities = br.readLine().trim().split(" ");
        for (int i = 0; i < N; i++) {
            q.offer(Integer.parseInt(qualities[i]));
        }

        int[][] conditions = new int[M][2];
        for (int i = 0; i < M; i++) {
            String[] condition = br.readLine().trim().split(" ");
            conditions[i][0] = Integer.parseInt(condition[0]); // day
            conditions[i][1] = Integer.parseInt(condition[1]); // requiredQuality
        }

        for (int i = 0; i < M; i++) {
            while (!q.isEmpty() && currentQuality < conditions[i][1]) {
                int currentBest = q.poll();
                currentQuality += currentBest + conditions[i][0];
            }
        }

        while (!q.isEmpty()) {
            currentQuality += q.poll() + conditions[M - 1][0];
        }

        if (currentQuality >= conditions[M - 1][1]) {
            System.out.println(currentQuality);
        } else {
            System.out.println(-1);
        }
    }
}
