import java.util.*;
import java.io.*;


public class Main{	
	public static int gcd(int x, int y) {
		if(y == 0) return x;
		return gcd(y, x%y);
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String[] line;
        for(int cycle = 0;cycle<N;cycle++) {
        	line = br.readLine().trim().split(" ");
	        int s = Integer.parseInt(line[0]);
	        long result = 0;
	        int[] number = new int[s];
	        for(int init = 1;init<=s;init++) {
	        	number[init-1] = Integer.parseInt(line[init]);
	        }
	        for(int i = 0;i<s-1;i++) {
	        	for(int j = i+1;j<s;j++) {
	        		result += gcd(number[i], number[j]);
	        	}
	        }
	        System.out.println(result);
        }
    }
    
}