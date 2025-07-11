import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[] numbers = new int[N];
		for(int i = 0;i<N;i++) {
			numbers[i] = Integer.parseInt(br.readLine().trim()) * -1;
		}
		Arrays.sort(numbers);
		int result = 0;
		for(int i = 0;i< N/3;i++) {
			result += numbers[i*3]*(-1)+numbers[i*3+1]*(-1);
		}
		for(int i = 0;i<N%3;i++) {
			result += numbers[N/3*3 + i]*(-1);
		}
		System.out.println(result);
	}
}
