import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        
        int count = 0;
        int lastClapTime = 0;
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x > lastClapTime) {
                count++;
                lastClapTime = x + K;
            }
        }
        System.out.println(count);
    }
}
