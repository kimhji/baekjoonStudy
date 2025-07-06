import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());
		int result = Integer.parseInt(br.readLine().trim());
		N--;
		for(int i = 0;i<N;i++) {
			result += Integer.parseInt(br.readLine().trim())-1;
		}
		
		System.out.println(result);
	}

}
