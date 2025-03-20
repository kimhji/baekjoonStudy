import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[] minV = new int[3];
		int[] maxV = new int[3];
		int[] tnsMin;
		int[] tnsMax;
		String[] line;
		for(int c = 0;c<N;c++) {
			line = br.readLine().trim().split(" ");
			tnsMin = new int[3];
			tnsMax = new int[3];
			for(int init = 0;init<3;init++) {
				int v = Integer.parseInt(line[init]);
				switch(init) {
				case 0:
					tnsMin[0] = (minV[0]<minV[1]?minV[0]:minV[1])+v;
					tnsMax[0] = (maxV[0]<maxV[1]?maxV[1]:maxV[0])+v;
					break;
				case 1:
					tnsMin[1] = (minV[0]<minV[1]?minV[2]<minV[0]?minV[2]:minV[0]:minV[1]<minV[2]?minV[1]:minV[2])+v;
					tnsMax[1] = (maxV[0]<maxV[1]?maxV[1]<maxV[2]?maxV[2]:maxV[1]:maxV[0]<maxV[2]?maxV[2]:maxV[0])+v;
					break;
				case 2:
					tnsMin[2] = (minV[1]<minV[2]?minV[1]:minV[2])+v;
					tnsMax[2] = (maxV[1]<maxV[2]?maxV[2]:maxV[1])+v;
					break;
				}
			}
			maxV = tnsMax;
			minV = tnsMin;
		}
		int resultMax = maxV[0]<maxV[1]?maxV[1]<maxV[2]?maxV[2]:maxV[1]:maxV[0]<maxV[2]?maxV[2]:maxV[0];
		int resultMin = minV[0]<minV[1]?minV[2]<minV[0]?minV[2]:minV[0]:minV[1]<minV[2]?minV[1]:minV[2];
		
		System.out.print(String.valueOf(resultMax)+" "+String.valueOf(resultMin));
	}
}