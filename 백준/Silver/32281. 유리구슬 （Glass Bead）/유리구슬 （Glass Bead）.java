import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());
		String base = br.readLine().trim();
		
		Long result = 0L;
		int inARow = 0;
		for(char one : base.toCharArray()) {
			if(one == '1') {
				inARow++;
				result+=inARow;	
			}
			else {
				inARow = 0;
			}
		}
		System.out.println(result);
	}

}
