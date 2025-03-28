import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[][] studentData = new int[N][5];
		for(int init=0;init<N;init++) {
			String[] line = br.readLine().trim().split(" ");
			for(int idx = 0;idx<5;idx++) {
				studentData[init][idx] = Integer.parseInt(line[idx]);	
			}
		}
		int[] result = new int[4];
		
		for(int findMax = 0;findMax<4;findMax++) {
			int tnsMax = studentData[0][findMax+1];
			int tnsIdx = 0;
			for(int std = 1;std<N;std++) {
				if(studentData[std][findMax+1] > tnsMax||studentData[std][findMax+1] == tnsMax && studentData[std][0] < studentData[tnsIdx][0]) {
					tnsMax = studentData[std][findMax+1];
					tnsIdx = std;
				}
			}
			result[findMax] = studentData[tnsIdx][0];
			studentData[tnsIdx][1] = -1;
			studentData[tnsIdx][2] = -1;
			studentData[tnsIdx][3] = -1;
			studentData[tnsIdx][4] = -1;
		}
		System.out.print(String.valueOf(result[0])+" "+String.valueOf(result[1])+" "+String.valueOf(result[2])+" "+String.valueOf(result[3]));
	}
}