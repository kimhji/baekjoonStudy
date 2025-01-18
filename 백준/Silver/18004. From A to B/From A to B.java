import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().trim().split(" ");
		int a = Integer.parseInt(line[0]);
		int b = Integer.parseInt(line[1]);
		
		int count = 0;
		while(a!=b) {
			count++;
			if(a%2==0 && a>b) {
				a/=2;
			}
			else {
				a++;
			}
		}
		System.out.print(count);
	}
}