import java.io.*;
import java.util.*;

class Main {

    public static int getGCD(int x, int y) {
        if (y == 0) {
            return x;
        }
        return getGCD(y, x % y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String[] StrData = br.readLine().trim().split(" ");
        int[] partialA = new int[N];
        for (int i = 0; i < N; i++) {
            partialA[i] = Integer.parseInt(StrData[i]);
        }

        int M = Integer.parseInt(br.readLine().trim());
        StrData = br.readLine().trim().split(" ");
        int[] partialB = new int[M];
        for (int i = 0; i < M; i++) {
            partialB[i] = Integer.parseInt(StrData[i]);
        }
        long result = 1L;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (partialA[i] == 1) {
                    break;
                }
                int commonV = getGCD(partialA[i], partialB[j]);
                partialA[i] /= commonV;
                partialB[j] /= commonV;
                result *= (long) commonV;
                if (result > 9999999999L) {
                    result %= 10_000_000_000L;
                }
            }
        }
        String tns = String.valueOf(result);
        String resultStr = tns.substring(Math.max(0, tns.length() - 9), tns.length());
        System.out.println(resultStr);
    }
}
