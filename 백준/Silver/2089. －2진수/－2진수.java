import java.io.*;
import java.util.*;


class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		String result = "";
		boolean is0 = true;
		while(Math.abs(N) > 0) {
			is0 = false;
			int tns = Math.abs(N)/2;
			int tnsR = Math.abs(N)%2;
			if(tnsR == 1) {
				result = "1"+result;
				if(N<0) {
					tns++;
				}
			}
			else {
				result = "0"+result;
			}
			if(N<0) {
				N = tns;
			}
			else {
				N = tns*(-1);
			}
		}
		if(is0) result = "0";
		System.out.println(result);
	}
}
