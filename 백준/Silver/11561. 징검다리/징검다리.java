import java.util.*;
import java.io.*;


public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int i = 0;i<T;i++) {
			long N = Long.parseLong(br.readLine().trim());
            long left = 0;
            long right = Integer.MAX_VALUE; 
            long result = 0;

            while (left <= right) {
                long mid = (left + right) >>> 1;
                long sum = (mid * (mid + 1)) / 2;

                if (sum <= N) {
                    result = Math.max(mid, result);
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            System.out.println(result);
            }
	}

}
