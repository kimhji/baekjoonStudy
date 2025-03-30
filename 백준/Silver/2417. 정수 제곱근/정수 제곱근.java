import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double data = Double.parseDouble(br.readLine().trim());
		double tns = Math.sqrt(data);
		long result = (long)tns;
		if(result*result < data) result++;
		System.out.print(result);
	}
}