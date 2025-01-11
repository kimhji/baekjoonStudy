import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String string = br.readLine().trim();
		int N = Integer.parseInt(br.readLine().trim())-1;
		char result = string.charAt(N);
		System.out.print(result);
	}
	
}