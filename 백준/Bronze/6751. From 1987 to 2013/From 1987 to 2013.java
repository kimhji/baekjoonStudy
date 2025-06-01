import java.util.*;
import java.io.*;


public class Main{	
	public static boolean isDistinct(int one) {
		char[] arr = String.valueOf(one).toCharArray();
		Set<Character> set = new HashSet<Character>();
		for(char oneC:arr) {
			if(set.contains(oneC)) {
				return false;
			}
			set.add(oneC);
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int result = N;
		while(!isDistinct(++result)) {
			;
		}
		System.out.println(result);
	}
}