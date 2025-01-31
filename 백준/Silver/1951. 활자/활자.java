import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine().trim());
        long many = 0;
        long tns = 10;
        int count = 1;
        
        while (N >= tns) {
            many += (tns - tns / 10) * count;
            many %= 1234567;
            tns *= 10;
            count++;
        }

        many += (N - tns / 10 + 1) * count;
        many %= 1234567;
        
        System.out.print(many);
    }
}
