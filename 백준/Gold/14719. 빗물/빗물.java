import java.util.*;
import java.io.*;


public class Main{	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().trim().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        
        inputs = br.readLine().trim().split(" ");
        int result = 0;
        boolean[][] board = new boolean[N][M];
        for(int init = 0;init<M;init++) {
        	int height = Integer.parseInt(inputs[init]);
        	for(int tns = 0;tns<height;tns++) {
        		board[tns][init] = true;
        	}
        }
        
        for(int cycle = 0;cycle<N;cycle++) {
        	int prevIdx = -1;
        	
	        for(int m = 0;m<M;m++) {
	        	if(board[cycle][m]) {
	        		if(prevIdx>=0) {
	        			result += m-prevIdx-1;
	        		}
	        		prevIdx = m;
	        	}
	        }
        }
        System.out.print(result);
    }
}