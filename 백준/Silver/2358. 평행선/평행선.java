import java.util.*;
import java.io.*;


public class Main{	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        Set<Integer> x = new HashSet<Integer>();
        Set<Integer> y = new HashSet<Integer>();
        Map<Integer, Integer> xMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> yMap = new HashMap<Integer, Integer>();
        
        int result = 0;
        for(int cycle = 0;cycle<N;cycle++) {
        	String[] line = br.readLine().trim().split(" ");
        	int a = Integer.parseInt(line[0]);
        	int b = Integer.parseInt(line[1]);
    		int count = xMap.getOrDefault(a, 0);
        	if(x.contains(a)&&count == 1) {
        		result++;
        	}
    		xMap.put(a, count+1);
    		x.add(a);
    		count = yMap.getOrDefault(b, 0);
        	if(y.contains(b)&&count == 1) {
        		result++;
        	}
    		yMap.put(b, count+1);
    		y.add(b);
        }
        
        System.out.println(result);
    }
    
}