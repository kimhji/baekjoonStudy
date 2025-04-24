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
        for(char one:line.toCharArray()) {
        	tnsNumber *= 10;
        	tnsNumber += one - '0';
        	if(tnsNumber / 100 > 0 && tnsNumber / 10 % 10 != 0 && one == '0') {
        		result++;
        		tnsNumber%=100;
        	}
        	if(tnsNumber > 641) {
        		result++;
        		tnsNumber %= 10;
        	}
        }
        System.out.print(result);
    }
}