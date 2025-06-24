import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		String[] line = br.readLine().trim().split(" ");
		int[] numbers = new int[N];
		for(int i = 0;i<N;i++) {
			numbers[i] = Integer.parseInt(line[i]);
		}
		Arrays.sort(numbers);
		System.out.println(numbers[0]*numbers[N-1]);
	}
}