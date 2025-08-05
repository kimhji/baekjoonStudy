import java.io.*;
import java.util.*;

class Main{		
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		String[] num_strs = br.readLine().trim().split(" ");
		int[] buildings = new int[N];
		int result = 0;
		int[] seeBuildings = new int[N];
		
		for(int i = 0;i<N;i++) {
			buildings[i] = Integer.parseInt(num_strs[i]);
		}
		for(int i = 0;i<N;i++) {
			for(int j = i-1;j>=0;j--) {
				double a = (buildings[i]-buildings[j])/(double)(i-j);
				boolean isView = true;
				for(int k = j+1;k<i;k++) {
					if(buildings[k] >= a*(k-j)+buildings[j]) {
						isView = false;
						break;
					}
				}
				if(isView) {
					seeBuildings[i]++;
					seeBuildings[j]++;
				}
			}
		}
		
		for(int i = 0;i<N;i++) {
			if(result < seeBuildings[i]) {
				result = seeBuildings[i];
			}
		}
		System.out.println(result);
		
	}
}
