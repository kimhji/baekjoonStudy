import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] inputData = br.readLine().trim().split(" ");
		int a = Integer.parseInt(inputData[0]);
		int b = Integer.parseInt(inputData[1]);
		
		System.out.print((a+b)*(a-b));
	}
}