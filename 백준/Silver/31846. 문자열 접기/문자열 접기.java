
import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        char[] chs = br.readLine().trim().toCharArray();
        int Q = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < Q; i++) {
            String[] argStr = br.readLine().trim().split(" ");
            int l = Integer.parseInt(argStr[0]) - 1;
            int r = Integer.parseInt(argStr[1]) - 1;

            int maxV = 0;
            for (int j = l + 1; j <= r; j++) {
                int tnsV = 0;
                int f = j - 1;
                int b = j;
                while (f >= l && b <= r) {
                    if (chs[f--] == chs[b++]) {
                        tnsV++;
                    }
                }
                if (maxV < tnsV) {
                    maxV = tnsV;
                }
            }
            System.out.println(maxV);
        }
    }
}
