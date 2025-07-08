import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[] solutions = new int[N];
		String[] solStrs = br.readLine().trim().split(" ");
		for(int i = 0;i<N;i++) {
			solutions[i] = Integer.parseInt(solStrs[i]);
		}
		Arrays.sort(solutions);
		int[] result = {0,0};
		int minDiff = -1;
		
		int left = 0;
		int right = N-1;
		while(left<right) {
			int sumV = Math.abs(solutions[left] + solutions[right]);
			if(minDiff<0||sumV<minDiff) {
				minDiff = sumV;
				result[0] = solutions[left];
				result[1] = solutions[right];
			}
			if(solutions[left] + solutions[right]<0) left++;
			else if(solutions[left] + solutions[right]>0) right--;
			else break;
		}
		
		System.out.println(result[0]+" "+result[1]);
	}
}
