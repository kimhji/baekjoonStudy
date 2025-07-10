import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		String[] line = br.readLine().trim().split(" ");
		int[] numbers = new int[N];
		int[] maxIncrease = new int[N];
		int[] maxDecrease = new int[N];
		for(int i = 0;i<N;i++) {
			numbers[i]=Integer.parseInt(line[i]);
			int tns = 0;
			for(int j=i-1;j>=0;j--) {
				if(numbers[j]<numbers[i] && tns < maxIncrease[j]) {
					tns = maxIncrease[j];
				}
			}
			maxIncrease[i] = tns+1;
		}
		for(int i = N-1;i>=0;i--) {
			int tns = 0;
			for(int j=i+1;j<N;j++) {
				if(numbers[j]<numbers[i] && tns < maxDecrease[j]) {
					tns = maxDecrease[j];
				}
			}
			maxDecrease[i] = tns+1;
		}
		int result = maxDecrease[0] + maxIncrease[0]-1;
		for(int i = 1;i<N;i++) {
			if(result < maxDecrease[i]+maxIncrease[i]-1) {
				result = maxDecrease[i]+maxIncrease[i]-1;
			}
		}
		System.out.println(result);
	}
}
