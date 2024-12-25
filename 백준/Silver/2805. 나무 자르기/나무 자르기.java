import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		String[] line = sc.readLine().trim().split(" ");
		int N = Integer.parseInt(line[0]);
		int need = Integer.parseInt(line[1]);
		line = sc.readLine().trim().split(" ");
		int [] trees = new int[N];
		int require = 0;
		
		for(int i=0;i<N;i++) {
			trees[i] = Integer.parseInt(line[i]);
			if(trees[i]>require) {
				require = trees[i];
			}
		}
		long sum = 0;
		int minV = 0;
		int maxV = require;
		while(minV!=maxV) {
			require = Math.floorDiv(maxV+minV, 2);
			sum = 0;
			for(int i=0;i<N;i++) {
				int tns =trees[i]-require;
				sum += tns>0?tns:0;
			}
			if(sum>=need) {
				if(minV == require) maxV = require;
				minV = require;
			}
			else {
				maxV = require;
			}
		}
		System.out.print(minV);
	}
}