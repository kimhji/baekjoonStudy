import java.util.*;
import java.io.*;

public class Main{
	public static int dcb(int x , int y) {
		if(y == 0) return x;
		return dcb(y, x%y);
	}
	
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int term = -1;
        int result = 0;
        int [] numbers = new int[N];
        for(int i = 0;i<N;i++) {
        	int tns = Integer.parseInt(br.readLine().trim());
        	numbers[i] = tns;
        }
        for(int i = 1;i<N;i++) {
        	int tns = numbers[i]-numbers[i-1];
        	if(term < 0) {
        		term = tns;
        	}
        	else {
        		term = dcb(term, tns);
        	}
        }
        int curN = numbers[0];
        int idx = 0;
        while(idx < N) {
        	if(numbers[idx] == curN) {
        		idx++;
        		curN += term;
        	}
        	else if(numbers[idx] < curN) {
        		idx++;
        	}
        	else {
        		curN += term;
        		result++;
        	}
        }
        
        
        System.out.print(result);
    }
}