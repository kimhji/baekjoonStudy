import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine().trim());
        int N = 1;
        while(N < K){
            N *= 2;
        }
        int splitCount = 0;
        int tns = N;
        while(K%tns != 0){
            tns /=2;
            splitCount++;
        }
        System.out.println(N+" "+splitCount);
    }
}