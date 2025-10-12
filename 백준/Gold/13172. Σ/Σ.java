import java.io.*;
import java.util.*;

class Main{
    static int mod = 1000000007;
    public static long modPow(long base, long exp) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
    public static int gcd(int x, int y){
        if(y == 0) return x;
        return gcd(y, x%y);
    }
    public static long get_reverseMod(int a){
        long result = modPow((long)a, (long)mod - 2);
        return result;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine().trim());
        long result = 0L;
        for(int i = 0;i<M;i++){
            String[] argStr = br.readLine().trim().split(" ");
            int N = Integer.parseInt(argStr[0]);
            int S = Integer.parseInt(argStr[1]);

            int common = gcd(N, S);
            N /= common;
            S /= common;
            long N_reverse = get_reverseMod(N);
            result += ((long)S*N_reverse) % mod;
            result %= mod;
        }
        System.out.println(result);
    }
}