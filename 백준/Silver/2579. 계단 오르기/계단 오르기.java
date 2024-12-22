import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[] arr1;
	static int[] arr2;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int N  = Integer.parseInt(sc.readLine());
		int[] numArr = new int[N]; 
		arr1 = new int[N];
		arr2 = new int[N];
		for(int i = 0 ;i<N;i++) {
			numArr[i] = Integer.parseInt(sc.readLine());
		}
		Main.findMaxVal(0, -1, N, numArr);
		System.out.print(arr1[N-1]>arr2[N-1]?arr1[N-1]:arr2[N-1]);
	}
	
	public static void findMaxVal(int count, int idx, int N, int[] arr) {
		if(idx+1 == N) {
			return;
		}
		int max1 = 0, max2 = 0;
		if(idx+1<N&&count<2) {
			if(count!=0) {
				arr2[idx+1] = arr2[idx+1]>arr1[idx]+arr[idx+1]?arr2[idx+1]:arr1[idx]+arr[idx+1];
			}
			else{
				arr1[idx+1] = arr1[idx+1]>arr[idx+1]?arr1[idx+1]:arr[idx+1];
			}

			findMaxVal(count+1, idx+1, N, arr);
		}
		if(idx+2<N) {
			int maxV = 0;
			if(count!=0) {
				maxV = arr1[idx]>arr2[idx]?arr1[idx]:arr2[idx];
			}
			if(arr1[idx+2]<arr[idx+2]+maxV) {
				arr1[idx+2] = arr1[idx+2]>arr[idx+2]+maxV?arr1[idx+2]:arr[idx+2]+maxV;
				findMaxVal(1, idx+2, N, arr);
			}
			
		}
		return;
	}
}
