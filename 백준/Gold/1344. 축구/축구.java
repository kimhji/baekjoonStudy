import java.io.*;
import java.util.*;

class Main {
    public static void isPrimeNumber(boolean[] isPrimeArr, int N){
        isPrimeArr[0] = false;
        isPrimeArr[1] = false;
        for(int i = 2;i<=N;i++){
            isPrimeArr[i] = true;
        }
        for(int i = 2;i<=N;i++){
            if(!isPrimeArr[i]) continue;
            int j = 2;
            while(i*j <= N){
                isPrimeArr[i*j] = false;
                j++;
            }
        }
    }

    public static double nCr(int n, int r) {
        double res = 1.0;
        for (int i = 0; i < r; i++) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double P1 = Integer.parseInt(br.readLine().trim())/(double)100;
        double P2 = Integer.parseInt(br.readLine().trim())/(double)100;

        int N = 18;
        boolean[] isPrimeArr = new boolean[N+1];
        isPrimeNumber(isPrimeArr, N);
        double noPrime_1 = 0;
        double noPrime_2 = 0;
        for(int i = 0;i<=N;i++){
            if(isPrimeArr[i]) continue;
            noPrime_1 += Math.pow(P1, i)*Math.pow(1-P1, N-i)*nCr(N, i);
            noPrime_2 += Math.pow(P2, i)*Math.pow(1-P2, N-i)*nCr(N, i);
        }
        System.out.println(1-noPrime_1*noPrime_2);
    }
}