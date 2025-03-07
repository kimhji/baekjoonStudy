import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());
		
		int count = 0;
		int curV = 1;
		
		while (count < N) {
			curV++;
			boolean isPrime = true;
			
			for(int check = 2;check <= Math.sqrt(curV);check++) {
				if(curV%check == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				count++;
			}
		}
		System.out.println(curV);
		
	}
}

