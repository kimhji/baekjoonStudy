import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		String[] inputs = br.readLine().trim().split(" ");

		int[] numbers = new int[N];
		for(int init = 0;init<N;init++) {
			numbers[init] = Integer.parseInt(inputs[init]);
		}
		boolean isExist = false;
		for(int c = N-1;c>0;c--) {
			if(numbers[c] > numbers[c-1]) {
				int tnsV = 10001;
				int tnsIdx = -1;
				for(int j = c;j<N;j++) {
					if(numbers[c-1] < numbers[j] && tnsV > numbers[j]) {
						tnsV = numbers[j];
						tnsIdx = j;
					}
				}
				numbers[tnsIdx] = numbers[c-1];
				numbers[c-1] = tnsV;
				for(int j = c;j<N-1;j++) {
					for(int k = j+1;k<N;k++) {
						if(numbers[j] > numbers[k]) {
							int tns2 = numbers[j];
							numbers[j] = numbers[k];
							numbers[k] = tns2;
						}
					}
				}
				isExist = true;
				break;
			}
		}
		if(isExist) {
			for(int p = 0;p<N;p++) {
				System.out.print(numbers[p]+" ");
			}
		}
		else {
			System.out.print(-1);
		}
	}

}
