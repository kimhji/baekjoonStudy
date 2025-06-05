import java.util.*;
import java.io.*;


public class Main{	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		String[] line = br.readLine().trim().split(" ");
		
		int[] lengthes = new int[N];
		long[] sum = new long[N];
		for(int init = 0;init<N;init++) {
			lengthes[init] = Integer.parseInt(line[init]);
		}
		Arrays.sort(lengthes);
		for(int init = N-1;init>=0;init--) {
			sum[init] = lengthes[init];
			if(init < N-1) {
				sum[init] += sum[init+1];
			}
		}
		
		long result = 0;
		for(int c = 1;c<N;c++) {
			result += lengthes[c-1] * sum[c];
		}
		System.out.println(result);
	}
}