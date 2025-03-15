import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().trim().split(" ");
		int leftE = 200 - Integer.parseInt(line[0]);
		int N = Integer.parseInt(line[1]);
		int result = 0;
		int[] objs = new int[N];
		line = br.readLine().trim().split(" ");
		for(int init = 0;init<N;init++) {
			objs[init] = Integer.parseInt(line[init]);
		}
		Arrays.sort(objs);
		for(int cycle = 0;cycle<N;cycle++) {
			if(leftE <= 0) {
				break;
			}
			result++;
			leftE -= objs[cycle];
		}
		System.out.print(result);
	}
}