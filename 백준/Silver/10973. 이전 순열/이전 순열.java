import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		String[] nums_S = br.readLine().trim().split(" ");
		int[] nums = new int[N];
		for(int init = 0;init<N;init++) {
			nums[init] = Integer.parseInt(nums_S[init]);
		}
		
		ArrayList<Integer> bag = new ArrayList<Integer>();
		boolean exist = false;
		for(int i = N-1;i>0;i--) {
			bag.add(nums[i]);
			if(nums[i]<nums[i-1]) {
				bag.sort(null);
				int bagL = bag.size();
				for(int k = bagL-1;k>=0;k--) {
					if(nums[i-1]>bag.get(k)) {
						int tns = nums[i-1];
						nums[i-1] = bag.get(k);
						bag.add(k, tns);
						bag.remove(k+1);
						break;
					}
				}
				for(int k = i, bag_idx = bagL-1;k<N;k++, bag_idx--) {
					nums[k] = bag.get(bag_idx);
				}
				exist = true;
				break;
			}
		}
		if(exist) {
			for(int i = 0;i<N;i++) {
				System.out.print(nums[i]+" ");
			}
		}
		else {
			System.out.print(-1);
		}
	}
}
