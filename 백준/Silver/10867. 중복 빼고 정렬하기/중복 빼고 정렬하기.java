import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		String[] line = br.readLine().trim().split(" ");
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0;i<N;i++) {
			set.add(Integer.parseInt(line[i]));
		}
		Integer[] arr = set.toArray(new Integer[0]);
		Arrays.sort(arr);
		for(Integer one:arr) {
			System.out.print(one+" ");
		}
	}
}
