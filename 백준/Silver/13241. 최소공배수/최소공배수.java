import java.util.*;
import java.io.*;

public class Main{
	public static long dcb(long x, long y) {
		if(y == 0) return x;
		
		return dcb(y, x%y);
	}
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split(" ");
        
        long a = Long.parseLong(line[0]);
        long b = Long.parseLong(line[1]);
        
        long common = dcb(a, b);
        System.out.println(String.valueOf(a*b/common));
    }
}