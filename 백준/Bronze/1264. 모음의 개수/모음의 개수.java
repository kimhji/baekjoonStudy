import java.util.*;
import java.io.*;


public class Main{	
	public static boolean isMo(char one) {
		switch(one) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			return true;
		default:
			return false;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine().trim().toLowerCase();
		while(!str.matches("#")) {
			int result = 0;
			for(char ch:str.toCharArray()) {
				if(isMo(ch)) result++;
			}
			
			System.out.println(result);
			str = br.readLine().trim().toLowerCase();
		}
	}
}