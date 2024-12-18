
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(sc.readLine());
		int[] numArr = new int[N];
		while(N-->0) {
			numArr[N]= Integer.parseInt(sc.readLine());
		}
		Arrays.sort(numArr);
		for (int i = numArr.length - 1; i >= 2; i--) {
            if (numArr[i] < numArr[i - 1] + numArr[i - 2]) {
            	System.out.print(numArr[i] + numArr[i - 1] + numArr[i - 2]);
                return;
            }
        }
		System.out.print(-1);
	}
}
