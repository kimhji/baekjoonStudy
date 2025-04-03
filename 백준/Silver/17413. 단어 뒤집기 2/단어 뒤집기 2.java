import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		int L = input.length();
		String result = "";
		String tns = "";
		boolean isTag = false;
		for(int i = 0;i<L;i++) {
			if(input.charAt(i) == '<') {
				isTag = true;
				int N = tns.length();
				for(int j = N-1;j>=0;j--) {
					result += tns.charAt(j);
				}
				tns = "";
			}
			if(isTag)
				result += input.substring(i, i+1);
			else {
				if(input.charAt(i) == ' ') {
					int N = tns.length();
					for(int j = N-1;j>=0;j--) {
						result += tns.charAt(j);
					}
					tns = "";
					result += " ";
				}
				else {
					tns += input.charAt(i);
				}
			}
			if(input.charAt(i) == '>') isTag = false;
		}
		int N = tns.length();
		for(int j = N-1;j>=0;j--) {
			result += tns.charAt(j);
		}
		System.out.print(result);
	}
}