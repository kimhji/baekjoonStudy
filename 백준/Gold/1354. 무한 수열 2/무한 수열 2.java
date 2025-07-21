import java.io.*;
import java.util.*;

class Main{
	static Map<Long, Long> infiniteArr = new HashMap<Long, Long>();
	public static long findA(long l, int P, int Q, int X, int Y) {
		if(infiniteArr.containsKey(l) || l <= 0) return infiniteArr.getOrDefault(l, 1L);
		long result = findA(l/P-X, P, Q, X, Y) + findA(l/Q-Y, P, Q, X, Y);
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
		int X = Integer.parseInt(argDatas[3]);
		int Y = Integer.parseInt(argDatas[4]);
		
		long result = findA(N, P, Q, X, Y);
		
		System.out.println(result);
	}
}
