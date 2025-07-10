import java.io.*;
import java.util.*;

class Main{
	//F[n] = F[n-1] + F[n-2]
	//F[n] = F[n-1] + F[n-2] + F[n-2] + F[n-3] = 3F[n-2] + 2F[n-3]
	//		F[n] = 5F[n-3] + 3F[n-4]
	//		F[n] = 8F[n-4] + 5F[n-5]
	//		F[n] = F[k+1]F[n-k] + F[k]F[n-k-1]
	public static Map<Long, Long> fiboV = new HashMap<Long, Long>();
	public static long fibo(long n) {
		if(fiboV.containsKey(n)) return fiboV.get(n);
		long val;
		if(n%2 == 0) {
			long f = fibo(n/2);
			long f_1 = fibo(n/2-1);
			val = (f * (2*f_1+f))%1000000007L;
		}
		else {
			long f = fibo(n/2);
			long f_1 = fibo(n/2+1);
			val =((f_1*f_1)%1000000007L + (f*f)%1000000007L)%1000000007L;
		}
		fiboV.put(n, val);
		return val;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine().trim());
		
		fiboV.put(0L, 0L);
		fiboV.put(1L, 1L);
		
		System.out.println(fibo(N));
	}
}
