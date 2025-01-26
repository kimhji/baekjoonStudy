import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(br.readLine().trim());
		String[] line = br.readLine().trim().split(" ");
		int[] needToSolve = new int[6];
		int[][] data = new int[T][2];
		
		for(int i = 1;i<=5;i++) {
			needToSolve[i] = Integer.parseInt(line[i-1]);
		}
    	for(int i = 0;i<T;i++) {
    		line = br.readLine().trim().split(" ");
    		int difficulty = Integer.parseInt(line[0]);
    		int time = Integer.parseInt(line[1]);
    		
    		data[i] = new int[] {difficulty, time};
    	}
    	
    	Arrays.sort(data, (a,b)-> a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
    	int beforeD = 1;
    	int beforeT = data[0][1];
    	int localNum = 0;
    	int time = 0;
    	for(int[] one: data) {
    		if(one[0] == beforeD) {
    			if(localNum >= needToSolve[beforeD]) {
    				continue;
    			}
    			localNum++;
    			time += one[1] - beforeT;
    			time += one[1];
    			beforeT = one[1];
    		}
    		else {
    			beforeD = one[0];
    			beforeT = one[1];
    			time+= 60;
    			time+= one[1];
    			localNum = 1;
    		}
    	}
    	System.out.print(time);
    }
}
