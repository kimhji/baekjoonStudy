import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		for(int i = 0;i<N;i++) {
			String line = br.readLine().trim();
			
			char first = line.charAt(0);
			char last = line.charAt(line.length()-1);
			System.out.println(first+""+last);
		}
	}
	
}