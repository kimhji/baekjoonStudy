import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] inputData = br.readLine().trim().split(" ");
		long a = Long.parseLong(inputData[0]);
		long b = Long.parseLong(inputData[1]);
		
		System.out.print((a+b)*(a-b));
	}
}