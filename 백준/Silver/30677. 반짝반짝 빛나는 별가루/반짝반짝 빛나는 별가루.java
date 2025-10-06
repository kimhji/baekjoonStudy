import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] argStr = br.readLine().trim().split(" ");
        int N = Integer.parseInt(argStr[0]);
        int K = Integer.parseInt(argStr[1]);
        int C = Integer.parseInt(argStr[2]);
        int R = Integer.parseInt(argStr[3]);
        int[] base = new int[K];
        int[] skill = new int[K];
        int[] s = new int[K];
        int[] p = new int[K];
        argStr = br.readLine().trim().split(" ");
        for(int i = 0;i<K;i++){
            base[i] = Integer.parseInt(argStr[i]);
        }
        argStr = br.readLine().trim().split(" ");
        for(int i = 0;i<K;i++){
            s[i] = Integer.parseInt(argStr[i]);
        }
        argStr = br.readLine().trim().split(" ");
        for(int i = 0;i<K;i++){
            p[i] = Integer.parseInt(argStr[i]);
        }
        long result = 0;
        int tired = 0;
        int combo = 0;
        for(int i = 0;i<N;i++){
            int n = Integer.parseInt(br.readLine().trim())-1;
            if(n<0){
                combo=0;
                tired-=R;
                if(tired<0) tired = 0;
                continue;
            }
            long temp = (long) base[n] * (100L + (long)combo * C) * (100L + (long)skill[n] * s[n]);
            long tnsDust = temp / 10000L;

            skill[n]++;
            combo++;
            tired += p[n];
            result += tnsDust;
            if(tired>100){
                result = -1;
                break;
            }
        }
        System.out.println(result);
    }
}