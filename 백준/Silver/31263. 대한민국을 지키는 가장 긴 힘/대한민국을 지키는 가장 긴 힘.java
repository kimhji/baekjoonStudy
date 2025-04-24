import java.util.*;
import java.io.*;


public class Main{	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        int N = Integer.parseInt(line);
        int result = 1;
        line = br.readLine().trim();
        int tnsNumber = 0;
        char [] ones=line.toCharArray();
        		
        for(int i = 0;i<N;i++) {
        	tnsNumber *= 10;
        	tnsNumber += ones[i] - '0';
        	if (tnsNumber > 641) {
        	    result++;
        	    tnsNumber = ones[i] - '0';  
        	} else if (i < N - 1 && ones[i] == '0' && ones[i + 1] == '0' && tnsNumber > 60) {
        	    result++;
        	    tnsNumber %= 100;
        	}
        }
        System.out.print(result);
    }
}