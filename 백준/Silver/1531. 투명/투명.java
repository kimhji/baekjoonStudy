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
        
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        
        int[][] board = new int[100][100];
        
        for(int cycle = 0;cycle<N;cycle++) {
        	line = br.readLine().trim().split(" ");
        	int[] loc_1 = new int[2];
        	int[] loc_2 = new int[2];
        	
        	loc_1[0] = Integer.parseInt(line[0])-1;
        	loc_1[1] = Integer.parseInt(line[1])-1;
        	loc_2[0] = Integer.parseInt(line[2])-1;
        	loc_2[1] = Integer.parseInt(line[3])-1;
        	
        	for(int y = loc_1[1];y<=loc_2[1];y++) {
        		for(int x = loc_1[0];x<=loc_2[0];x++) {
        			board[y][x]++;
        		}
        	}
        }
        int result =0;
        for(int y = 0;y<100;y++) {
    		for(int x = 0;x<100;x++) {
    			if(board[y][x]>M) result++;
    		}
    	}
        System.out.println(result);
    }
}