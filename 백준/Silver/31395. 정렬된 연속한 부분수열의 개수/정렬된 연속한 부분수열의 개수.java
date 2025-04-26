import java.util.*;
import java.io.*;


public class Main{	
	public static void dfs(int[] numbers, int idx_f) {
		
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine().trim());
        String[] line = br.readLine().trim().split(" ");
        int[] numbers = new int[N];
        
        for(int init = 0;init<N;init++) {
        	numbers[init] =  Integer.parseInt(line[init]);
        }
        long result = N;
        long tnsL = 0;
        for(int cycle = 0;cycle<N-1;cycle++) {
        	if(numbers[cycle]<numbers[cycle+1]) {
        		result += ++tnsL;
        	}
        	else {
        		tnsL = 0;
        	}
        }
        System.out.print(result);
    }
}