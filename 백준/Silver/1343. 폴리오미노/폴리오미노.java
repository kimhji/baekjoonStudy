import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine().trim();
		int xNum = 0;
		String result = "";
		for(char one:line.toCharArray()) {
			if(one == 'X') {
				xNum++;
				if(xNum == 4) {
					result += "AAAA";
					xNum = 0;
				}
			}
			else {
				if(xNum == 2) {
					result += "BB";
					xNum = 0;
				}
				else if(xNum%2 == 1) {
					xNum = -1;
					break;
				}
				result += ".";
			}
		}
		if(xNum == 4) {
			result += "AAAA";
		}
		else if(xNum == 2) {
			result += "BB";
		}
		else if(xNum%2 == 1 || xNum < 0){
			result = "-1";
		}
		System.out.println(result);
	}
}