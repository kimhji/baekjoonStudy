import java.util.*;
import java.io.*;


public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        
        for(int i = 1;i<=N;i++) {
        	System.out.println(" ".repeat(N-i)+"*".repeat(i*2-1));
        }
    }
}