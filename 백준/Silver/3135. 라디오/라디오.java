import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split(" ");
        int A = Integer.parseInt(line[0]);
        int B = Integer.parseInt(line[1]);
        
        int minValue = Math.abs(A-B);
        
        int N = Integer.parseInt(br.readLine().trim());
        for(int i = 0;i<N;i++) {
        	int one = Integer.parseInt(br.readLine().trim());
        	if(Math.abs(one-B)+1<minValue) {
        		minValue = Math.abs(one-B)+1;
        	}
        }
        System.out.println(minValue);
    }
}