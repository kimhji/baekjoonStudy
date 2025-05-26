import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for(int cycle = 0;cycle<T;cycle++) {
        	String[] line = br.readLine().trim().split(" ");
	        int h = Integer.parseInt(line[0]);
	        int l = Integer.parseInt(line[1]);
	        Map<Integer, int[]> locBag = new HashMap<Integer, int[]>();
	        int[][] board = new int[h][l];
	        int[] curBelt = new int[h];
	        for(int init_r = 0;init_r<h;init_r++) {
	        	line = br.readLine().trim().split(" ");
	        	for(int init_c = 0;init_c<l;init_c++) {
	        		int order = Integer.parseInt(line[init_c]);
	        		board[init_r][init_c] = order;
	        		if(order > 0) {
	        			int[] loc = {init_r, init_c};
	        			locBag.put(order, loc);
	        		}
	        	}
	        }
	        int count = 1;
	        int[] loc = locBag.get(count);
	        int time = 0;
	        while(loc != null) {
	        	time += loc[0]*2*10;
	        	int diffL = Math.abs((curBelt[loc[0]] - loc[1]+l)%l);
	        	int diffL_2 = Math.abs((l - curBelt[loc[0]] + loc[1])%l);
	        	if(diffL > diffL_2) diffL = diffL_2; 
	        	if(diffL != 0) {
	        		time += diffL*5;
	        		curBelt[loc[0]] = loc[1];
	        	}
	        	
	        	count++;
		        loc = locBag.get(count);
	        }
	        System.out.println(time);
        }
       
    }
}