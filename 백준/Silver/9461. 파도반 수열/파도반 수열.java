import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int N  = Integer.parseInt(sc.readLine());
		long[] arr = Main.initValue();
		
		for(int i = 0 ;i<N;i++) {
			int curV = Integer.parseInt(sc.readLine());
			System.out.print(arr[curV]+"\n");
		}
	}
	
	public static long[] initValue() {
		long[] arr = new long[101];
		arr[1] = 1L;
		arr[2] = 1L;
		arr[3] = 1L;
		arr[4] = 2L;
		arr[5] = 2L;
		
		for(int i=6;i<=100;i++) {
			arr[i] = arr[i-1]+arr[i-5];
		}
		
		return arr;
	}
}
