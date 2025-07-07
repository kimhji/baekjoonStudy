import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int val_00 = 0;
		int val_01 = 0;
		int val_10 = 0;
		int val_11 = 0;
		
		for(int i = 0;i<N;i++) {
			int val = Integer.parseInt(br.readLine().trim());
			int val_next_10 = val_11<val_01?val_01:val_11;
			int val_next_00 = val_00<val_10?val_10:val_00;
			int val_next_01 = (val_00<val_10?val_10:val_00)+val;
			int val_next_11 = val_01+val;
			val_00 = val_next_00;
			val_01 = val_next_01;
			val_10 = val_next_10;
			val_11 = val_next_11;
		}
		
		int maxV = Math.max(Math.max(val_10, val_11), Math.max(val_00, val_01));
		System.out.println(maxV);
	}
}
