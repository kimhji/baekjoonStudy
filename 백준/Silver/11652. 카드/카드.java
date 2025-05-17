import java.util.*;
import java.io.*;


public class Main{	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        Long maxV = 0L;
        int maxCount = 0;
        
        Map<Long, Integer> dict = new HashMap<Long, Integer>();
        for(int init = 0;init<N;init++) {
        	long num = Long.parseLong(br.readLine().trim());
        	int count = dict.getOrDefault(num, 0)+1;
        	dict.put(num, count);
        	if(count > maxCount || count == maxCount && num < maxV) {
        		maxCount = count;
        		maxV = num;
        	}
        }
        System.out.println(maxV);
	}
    
}