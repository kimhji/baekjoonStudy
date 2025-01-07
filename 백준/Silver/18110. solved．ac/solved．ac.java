import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int exclude = Math.round(0.15f*N);
		Integer[] data = new Integer[N];
		for(int i = 0;i<N;i++) {
			data[i] = Integer.parseInt(br.readLine().trim());
		}
		Arrays.sort(data, (a,b)->a-b);
		int sum = 0;
		int num = 0;
		for(int i = exclude;i<N-exclude;i++) {
			sum += data[i];
			num++;
		}
		System.out.print(Math.round((double)sum/num));
	}
}