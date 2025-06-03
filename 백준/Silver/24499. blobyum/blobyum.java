import java.util.*;
import java.io.*;


public class Main{	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().trim().split(" ");
		int N = Integer.parseInt(line[0]);
		int K = Integer.parseInt(line[1]);
		
		int[] applepie = new int[N];
		line = br.readLine().trim().split(" ");
		for(int init = 0;init<N;init++) {
			applepie[init] = Integer.parseInt(line[init]) + (init>0?applepie[init-1]:0);
		}
		int maxValue = 0;
		for(int i = 0;i<N;i++) {
			int tnsV = 0;
			if(i+K>N) {
				tnsV = applepie[N-1] - (i==0?0:applepie[i-1] - applepie[(i+K-1)%N]);
			}
			else {
				tnsV = applepie[i+K-1] - (i==0?0:applepie[i-1]);
			}
			
			if(maxValue < tnsV) maxValue = tnsV;
		}
		System.out.println(maxValue);
	}
}