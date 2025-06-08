import java.util.*;
import java.io.*;


public class Main{	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		String[] line = br.readLine().trim().split(" ");
		int[] minSizeOfNum = new int[5001];
		int result = 0;
		for(String one: line) {
			int val = Integer.parseInt(one);
			int findNum = 0;
			for(int c = 5000;c>0;c--) {
				if(minSizeOfNum[c] != 0 && minSizeOfNum[c]<val) {
					findNum = c;
					break;
				}
			}
			findNum++;
			if(minSizeOfNum[findNum] == 0 || minSizeOfNum[findNum]>val) {
				minSizeOfNum[findNum] = val;
				if(result < findNum) result = findNum;
			}
		}
		
		System.out.println(result);
	}
}