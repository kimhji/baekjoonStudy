import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int result = 0;
		String input = br.readLine().trim();
		int curOpen = 0;
		boolean isBeforeOpen = false;
		for(char one : input.toCharArray()) {
			if(one == '(') {
				curOpen++;
				isBeforeOpen = true;
			}
			else if(one == ')') {
				curOpen--;
				if(isBeforeOpen) {
					result += curOpen;
				}
				else {
					result++;
				}
				isBeforeOpen = false;
			}
		}
		System.out.println(result);
	}
}
