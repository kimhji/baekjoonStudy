import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine().trim());
		if (N == 0) {
            System.out.println(0);
            return;
        }
		String num_3 = "";
		while(N > 0) {
			num_3 = N%7 + num_3;
			N = Math.floorDiv(N, 7);
		}
		int result =0;
		for(char one:num_3.trim().toCharArray()) {
			result *= 3;
			result += Character.getNumericValue(one);
		}
		System.out.print(result);
	}
	
}