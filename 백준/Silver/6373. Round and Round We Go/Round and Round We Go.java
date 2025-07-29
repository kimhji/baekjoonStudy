import java.io.*;
import java.math.BigInteger;
import java.util.*;


class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		while(line!= null) {
			line = line.trim();
			BigInteger number = new BigInteger(line);
			int N = line.length();
			boolean result = true;
			for(int i = 2;i<=N;i++) {
				boolean tnsR = false;
				String comp = String.valueOf(number.multiply(BigInteger.valueOf(i)));
				if(comp.length() < line.length()) {
					comp = "0".repeat(line.length() - comp.length()) + comp;
				}
				for(int j = 0;j<N;j++) {
					if(line.compareTo(comp.substring(j, N)+comp.substring(0, j))== 0) {
						tnsR = true;
						break;
					}
				}
				if(!tnsR) {result = false;break;}
			}
			if(result) {
				System.out.println(line + " is cyclic");
			}
			else {
				System.out.println(line + " is not cyclic");
			}
			
			line = br.readLine();
		}
	}
}
