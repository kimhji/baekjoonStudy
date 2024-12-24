import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		char[] line = sc.readLine().trim().toCharArray();
		int result = 0;
		int curNum = 0;
		boolean isMinus = false;
		for(int i = 0;i<line.length;i++) {
			if(isNumeric(line[i])) {
				curNum *= 10;
				curNum += line[i]-'0';
				continue;
			}
			if(isMinus) {
				result -= curNum;
				curNum = 0;
			}
			else {
				result += curNum;
				curNum = 0;
			}
			if(line[i] == '-') {
				isMinus = true;
			}
		}
		if(isMinus) {
			result -= curNum;
			curNum = 0;
		}
		else {
			result += curNum;
			curNum = 0;
		}
		System.out.print(result);
	}
	
	public static boolean isNumeric(char one) {
		return one>='0'&&one<='9';
	}
}
