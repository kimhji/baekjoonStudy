import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int result = 0;
		for(int i = 0;i<N;i++) {
			String word = br.readLine().trim();
			Stack<Character> stack = new Stack<Character>();
			int len = 0;
			for(char one: word.toCharArray()) {
				if(len == 0 || stack.peek() != one) {
					stack.add(one);
					len++;
				}
				else {
					stack.pop();
					len--;
				}
			}
			if(len == 0) result++;
		}
		System.out.print(result);
	}
}
