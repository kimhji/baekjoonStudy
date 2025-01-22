import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] inputData = br.readLine().trim().split(" ");
		int N = Integer.parseInt(inputData[0]);
		int K = Integer.parseInt(inputData[1]);
		Integer [] pluralWine = new Integer[N];
		inputData = br.readLine().trim().split(" ");
		for(int i = 0;i<N;i++) {
			pluralWine[i] = Integer.parseInt(inputData[i]);
		}
		Arrays.sort(pluralWine,(Integer a,Integer b)->b-a);
		long maxV = 0;
		int beforeWine = 0;
		for(int i = 0;i<Math.floorDiv(K, 2);i++) {
			maxV += pluralWine[i]-beforeWine;
			beforeWine = pluralWine[N-i-1];
		}
		if(K%2 == 1) {
			maxV += pluralWine[Math.floorDiv(K, 2)]-beforeWine;
		}
		System.out.print(maxV);
	}
}