import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] argStr = br.readLine().trim().split(" ");
        int N = Integer.parseInt(argStr[0]);
        int M = Integer.parseInt(argStr[1]);
        
        Map<String, Integer> rowCount = new HashMap<>();
        String[] rows = new String[N];

        for (int i = 0; i < N; i++) {
            rows[i] = br.readLine().trim();
            rowCount.put(rows[i], rowCount.getOrDefault(rows[i], 0) + 1);
        }

        int K = Integer.parseInt(br.readLine().trim());

        int result = 0;
        for (String row : rowCount.keySet()) {
            int zeroCount = 0;
            for (char c : row.toCharArray()) {
                if (c == '0') zeroCount++;
            }
            if (zeroCount <= K && (K - zeroCount) % 2 == 0) {
                result = Math.max(result, rowCount.get(row));
            }
        }

        System.out.println(result);
    }
}
