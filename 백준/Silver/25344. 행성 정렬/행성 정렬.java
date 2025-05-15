import java.util.*;
import java.io.*;


public class Main{	
	public static int dcb(int x, int y) {
		if(y == 0) return x;
		return dcb(y, x%y);
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        
        String[] line = br.readLine().trim().split(" ");
        int result = 1;
        
        for(int init = 0;init<N-2;init++) {
        	int planet = Integer.parseInt(line[init]);
        	int common = dcb(result, planet);
        	result *= planet/common;
        }
        System.out.println(result);
	}
    
}