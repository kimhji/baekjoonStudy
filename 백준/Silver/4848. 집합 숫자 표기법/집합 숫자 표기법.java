import java.util.*;
import java.io.*;
public class Main{
	public static String makeStr(int n) {
		if(n == 0) return "{}";
		String result = "{";
		for(int i = 0;i<n;i++) {
			result += makeStr(i);
			if(i<n-1) {
				result += ",";
			}
		}
		result += "}";
		return result;
	}
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for(int c = 0;c<T;c++) {
        	String line1 = br.readLine().trim();
        	String line2 = br.readLine().trim();
        	int n1 = 0;
        	int n2 = 0;
        	for(char ch:line1.toCharArray()) {
        		if(ch == '}') n1++;
        		else n1 = 0;
        	}
        	for(char ch:line2.toCharArray()) {
        		if(ch == '}') n2++;
        		else n2 = 0;
        	}
        	String result = makeStr(n1+n2-2);
        	System.out.println(result);
        }
    }
}