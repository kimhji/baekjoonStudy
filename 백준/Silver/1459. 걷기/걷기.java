import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().trim().split(" ");
		long n = Long.parseLong(inputs[0]);
		long m = Long.parseLong(inputs[1]);
		long st = Long.parseLong(inputs[2]);
		long cr = Long.parseLong(inputs[3]);
		
		long result = 0;
		while(n != 0 || m != 0) {
			if(Math.abs(n)+Math.abs(m) == 1) {
				result += st;
				break;
			}
			else {
				if(st*2 < cr) {
					result += st*(Math.abs(n)+Math.abs(m));
					break;
				}
				if(Math.abs(n)>0 && Math.abs(m)>0) {
					long min = Math.abs(n)<Math.abs(m)?Math.abs(n):Math.abs(m);
					result += cr*min;
					if(n>0) {
						n -= min;
					}
					else {
						n += min;
					}
					if(m>0) {
						m -= min;
					}
					else {
						m += min;
					}
				}
				if(Math.abs(n)>=2) {
					if(n>0) n-=2;
					else n += 2;
					if(cr<st) {
						result += cr*2;
					}
					else {
						result += st*2;
					}
				}
				if(Math.abs(m)>=2) {
					if(m>0) m-=2;
					else m += 2;
					if(cr<st) {
						result += cr*2;
					}
					else {
						result += st*2;
					}
				}
			}
		}
		System.out.print(result);
	}

}
