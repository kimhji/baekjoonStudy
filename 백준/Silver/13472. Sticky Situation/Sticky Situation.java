import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = (int) read();
        long[] arr = new long[n];
        while (n-- > 0) arr[n] = read();

        Arrays.sort(arr);

        bw.write(isPossible(arr));
        bw.flush();
    }

    private static String isPossible(long[] arr) {
        for (int i = 2; i < arr.length; i++) if (arr[i - 2] + arr[i - 1] > arr[i]) return "possible";

        return "impossible";
    }

    private static long read() throws IOException {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);

        return n;
    }

}