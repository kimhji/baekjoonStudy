import java.util.*;
import java.io.*;


public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);
        int[] arr = new int[N];
        line = br.readLine().trim().split(" ");
        for(int i = 0;i<N;i++) {
        	arr[i] = Integer.parseInt(line[i]);
        }
        Arrays.sort(arr);
        System.out.println(arr[K-1]);
    }
}