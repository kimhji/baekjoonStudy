import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        List<Integer> sequence = new ArrayList<>();
        for (int i = 1; sequence.size() < B; i++) {
            for (int j = 0; j < i; j++) {
                sequence.add(i);
            }
        }

        int sum = 0;
        for (int i = A - 1; i < B; i++) {
            sum += sequence.get(i);
        }

        System.out.println(sum);
    }
}
