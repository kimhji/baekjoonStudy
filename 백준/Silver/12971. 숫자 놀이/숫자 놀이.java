
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().trim().split(" ");
        int P1 = Integer.parseInt(data[0]);
        int P2 = Integer.parseInt(data[1]);
        int P3 = Integer.parseInt(data[2]);
        int X1 = Integer.parseInt(data[3]);
        int X2 = Integer.parseInt(data[4]);
        int X3 = Integer.parseInt(data[5]);

        int P1_t = X1;
        int P2_t = X2;
        int P3_t = X3;
        int result = -1;
        final int MAXV = 1_000_000_000;

        while (true) {
            int max = Math.max(P1_t, Math.max(P2_t, P3_t));
            if (max >= MAXV) {
                System.out.println(-1);
                return;
            }
            if (P1_t == P2_t && P2_t == P3_t) {
                System.out.println(P1_t);
                return;
            }
            if (P1_t < max) {
                P1_t += P1;
            }
            if (P2_t < max) {
                P2_t += P2;
            }
            if (P3_t < max) {
                P3_t += P3;
            }
        }

        // if (P1_t == P2_t && P1_t == P3_t) {
        //     result = P1_t;
        // }
        // System.out.println(result);
    }
}
