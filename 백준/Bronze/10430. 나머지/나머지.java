import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().trim().split(" ");
		int A = Integer.parseInt(line[0]);
		int B = Integer.parseInt(line[1]);
		int C = Integer.parseInt(line[2]);
		
		System.out.println((A+B)%C);
		System.out.println(((A%C)+(B%C))%C);

		System.out.println((A*B)%C);
		System.out.println(((A%C)*(B%C))%C);
	}
}