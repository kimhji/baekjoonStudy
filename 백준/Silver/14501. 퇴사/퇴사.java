import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] data = new int[N][2];
		int[] maxValArr = new int[N];
		for(int i =0;i<N;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			data[i][0] = a;
			data[i][1] = b;
			maxValArr[i] = b;
		}
		int result = 0;
		for(int i =0;i<N;i++) {
			if(i+data[i][0]>N) continue;
			for(int j = data[i][0]+i;j<N;j++) {
				int curVal =data[j][1]+ maxValArr[i];
				if(maxValArr[j]<curVal) {
					maxValArr[j] = curVal;
				}
			}
			if(result<maxValArr[i]) {
				result = maxValArr[i];
			}
		}
		System.out.print(result);
	}

}
