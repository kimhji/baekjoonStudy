import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] weights = new int[N];
        String[] w_str = br.readLine().trim().split(" ");
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(w_str[i]);
        }

        Arrays.sort(weights);

        int target = 1; 
        for (int weight : weights) {
            if (weight > target) break;
            target += weight;
        }

        System.out.println(target);
    }
}
