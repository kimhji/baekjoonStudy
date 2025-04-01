import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		List<Integer> arr = new ArrayList<Integer>();
		String[] arrString = br.readLine().trim().split(" ");
		for(int init = 0;init<N;init++) {
			arr.add(Integer.parseInt(arrString[init]));
		}
		int x = Integer.parseInt(br.readLine().trim());
		Collections.sort(arr);
		int result = 0;
		int l = 0;
		int r = N-1;
		while(l<r) {
			if(arr.get(l)+arr.get(r) == x) {
				result++;
				l++;
				r--;
			}
			else if(arr.get(l)+arr.get(r)>x) {
				r--;
			}
			else {
				l++;
			}
		}
		System.out.print(result);
	}
}