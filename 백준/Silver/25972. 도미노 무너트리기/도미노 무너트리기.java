import java.io.*;
import java.util.*;

public class Main {
    
    static class Domino implements Comparable<Domino> {
        int a; 
        int l; 
        
        Domino(int a, int l) {
            this.a = a;
            this.l = l;
        }
        
        @Override
        public int compareTo(Domino o) {
            return this.a - o.a; 
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        Domino[] arr = new Domino[N];
        
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int l = Integer.parseInt(input[1]);
            arr[i] = new Domino(a, l);
        }
        
        Arrays.sort(arr);
        
        int ans = 0;      
        int old = -1;     
        
        for (int i = 0; i < N; i++) {
            if (old < arr[i].a) {  
                ans++;
            }
            old = arr[i].a + arr[i].l;  
        }
        
        System.out.println(ans);
    }
}
