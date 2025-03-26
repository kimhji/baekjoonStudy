import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().trim().split(" ");
		int n = Integer.parseInt(inputs[0]);
		int m = Integer.parseInt(inputs[1]);
		int t = Integer.parseInt(inputs[2]);
		int less = n<m?n:m;
		int more = less==m?n:m;
		int diff = more-less;
		int time_result = t%less;
		int result = t/less;
		int l_n = result;
		int m_n = 0;
		while(l_n > 0) {
			int tnsT = (--l_n)*less+m_n*more;
			if(tnsT + more <= t) {
				m_n++;
				tnsT += more;
			}
			if(t-tnsT < time_result) {
				time_result = t-tnsT;
				result = l_n+m_n;
			}
		}
		System.out.printf("%d %d", result, time_result);
	}

}
