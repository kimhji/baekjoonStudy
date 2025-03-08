import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int count_0 = 0;
		int count_1 = 0;
		
		String line = br.readLine().trim();
		boolean is0 = line.charAt(0)=='0'?false:true;
		
		for(char one:line.toCharArray()) {
			if(is0 && one=='1') {
				count_1++;
				is0 = false;
			}
			else if(!is0 && one == '0') {
				count_0++;
				is0 = true;
			}
		}
		int result = count_0<count_1?count_0:count_1;
		System.out.println(result);
	}
}