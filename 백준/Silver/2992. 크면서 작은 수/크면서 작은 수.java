import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String result = "";
		String input = br.readLine().trim();
		int[] numMap = new int[10];
		int len = input.length();
		for(int c = len-1;c>0;c--) {
			numMap[(input.charAt(c)-'0')]++;
			if(input.charAt(c)>input.charAt(c-1)) {
				result += input.substring(0, c-1);
				numMap[input.charAt(c-1)-'0']++;
				for(int i = input.charAt(c-1)-'0'+1;i<10;i++) {
					if(numMap[i]==0) continue;
					result += i;
					numMap[i]--;
					break;
				}
				for(int i = 0;i<10;i++) {
					if(numMap[i]==0) continue;
					result += i;
					numMap[i]--;
					i--;
				}
				break;
			}
		}
		if("".compareTo(result)==0) {
			System.out.print(0);
		}
		else {
			System.out.print(result);
		}
	}
}
