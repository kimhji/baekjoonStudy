import java.util.*;
import java.io.*;


public class Main{	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().trim().split(" ");
		int R = Integer.parseInt(line[0]);
		int C = Integer.parseInt(line[1]);
		int N = Integer.parseInt(br.readLine().trim());
		line = br.readLine().trim().split(" ");
		int[] dolls = new int[N];
		for(int i = 0;i<N;i++) {
			dolls[i] = Integer.parseInt(line[i]);
		}
		Arrays.sort(dolls);
		int[][] table = new int[R][C];
		int idx = 0;
		for(int i = 0;i<R;i++) {
			for(int j = 0;j<C;j++) {
				table[i][j] = dolls[idx++];
				while(i>0 && table[i][j] == table[i-1][j]) {
                    if(idx >= N) break;
					table[i][j] = dolls[idx++];
				}
				if(idx >= N) break;
			}
			if(idx >= N) break;
		}
		int result = 0;
		for(int i = 0;i<C;i++) {
			if(table[0][i] > 0) result++;
			for(int j = 1;j<R;j++) {
				if(table[j-1][i]<table[j][i]) result++;
			}
		}
		
		System.out.println(result);
	}
}