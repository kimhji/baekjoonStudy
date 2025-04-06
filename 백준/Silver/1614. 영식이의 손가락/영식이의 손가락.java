import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int where = Integer.parseInt(br.readLine().trim());
		long howMany = Long.parseLong(br.readLine().trim());
		long result = 0;
		if (where == 5 || where == 1) {
			result = 8 * howMany;
			result += where==5?4:0;
		}
		else {
			result = 8 * (howMany/2);
			if(howMany%2 == 1) {
				switch(where) {
				case 2:
					result += 7;
					break;
				case 3:
					result += 6;
					break;
				case 4:
					result += 5;
					break;
				}
			}
			else {
				switch(where) {
				case 2:
					result += 1;
					break;
				case 3:
					result += 2;
					break;
				case 4:
					result += 3;
					break;
				}
			}
		}
		System.out.print(result);
	}
}