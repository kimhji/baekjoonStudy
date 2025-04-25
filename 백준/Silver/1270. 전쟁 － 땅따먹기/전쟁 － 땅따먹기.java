import java.util.*;
import java.io.*;


public class Main{	
	static String StillWar = "SYJKGW";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine().trim());
        HashMap<Long, Integer> dict = new HashMap<Long, Integer>();
        for(int cycle=0;cycle<N;cycle++) {
        	String[] line = br.readLine().trim().split(" ");
        	int M = Integer.parseInt(line[0]);
        	dict.clear();
        	Long mainArmy = -1L;
        	int maxCount = 0;
        	for(int one = 1;one<=M;one++) {
        		long armyNumber = Long.parseLong(line[one]);
        		int count = dict.getOrDefault(armyNumber, 0)+1;
        		dict.put(armyNumber , count);
        		if(count > maxCount) {
        			maxCount = count;
        			mainArmy = armyNumber;
        		}
        	}
        	if(M/2>=maxCount) {
        		System.out.println(StillWar);
        	}
        	else {
        		System.out.println(mainArmy);
        	}
        }
    }
}