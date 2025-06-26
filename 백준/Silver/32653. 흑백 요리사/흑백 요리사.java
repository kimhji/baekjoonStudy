import java.util.*;
import java.io.*;

class Main{
	public static long gcd(long x, long y) {
		if(y == 0) return x;
		return gcd(y, x%y);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		String[] line = br.readLine().trim().split(" ");
		long result = 1L;
		for(int i = 0;i<N;i++) {
			long data = Long.parseLong(line[i])*2;
			result *= (data/gcd(data, result));
		}
		
		System.out.println(result);
	}
}