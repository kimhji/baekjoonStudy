import java.io.*;
import java.util.*;

class Main{
	static Map<Long, Long> infiniteArr = new HashMap<Long, Long>();
	public static long findA(long l, int P, int Q) {
		if(infiniteArr.containsKey(l)) return infiniteArr.get(l);
		long result = findA(l/P, P, Q) + findA(l/Q, P, Q);
		infiniteArr.put(l, result);
		return result;
	}
	
	public static void main(String[] args) throws IOException{
		infiniteArr.put(0L, 1L);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] argDatas = br.readLine().trim().split(" ");
		long N = Long.parseLong(argDatas[0]);
		int P = Integer.parseInt(argDatas[1]);
		int Q = Integer.parseInt(argDatas[2]);
		
		long result = findA(N, P, Q);
		
		System.out.println(result);
	}
}
