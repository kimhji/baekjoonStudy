import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		String line = sc.readLine();
		while(line != null) {
			String[] datas = line.split(" ");
			int num = Integer.parseInt(datas[1])-1;
			char[] sortedArr = datas[0].toCharArray();
			int length = datas[0].length();
			int[] timesArr = new int[length];
			boolean[] visitedArr = initVisitedArr(length);
			for(int i=length-1, j=1;i>=0;i--,j++) {
				timesArr[i] = 1; 
				if(j != 1) {
					timesArr[i] = timesArr[i+1]*j;
				}
			}
			
			int curIdx = 0;
			String result = "";
			while(result.length() != length) {
				if(num > timesArr[curIdx++]) {
					System.out.printf("%s %s = No permutation\n", datas[0], datas[1].trim());
					break;
				}
				if(curIdx>=length) {
					curIdx--;
				}
				int goal = num/timesArr[curIdx];
				for(int search = 0;search<length;search++) {
					if(visitedArr[search]) {
						goal++;
					}
					else if(goal == search){
						result += sortedArr[search];
						visitedArr[search] = true;
						break;
					}
				}
				num %= timesArr[curIdx];
			}
			if(!result.isEmpty()) {
				System.out.printf("%s %s = "+result+"\n", datas[0],  datas[1].trim());			}
			line = sc.readLine();
		}
	}
	
	public static boolean[] initVisitedArr(int length) {
		boolean[] visitedArr = new boolean[length];
		for(int i = 0;i<length;i++) {
			visitedArr[i] = false;
		}
		
		return visitedArr;
	}
}
