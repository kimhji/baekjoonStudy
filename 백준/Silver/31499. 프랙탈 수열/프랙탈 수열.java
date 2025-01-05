import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] line = br.readLine().trim().split(" ");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		long data = 1;
		
		for(int i = 1;i<=N;i++) {
			data *= i;
			data %= M;
		}
		System.out.print(data);
	}
}