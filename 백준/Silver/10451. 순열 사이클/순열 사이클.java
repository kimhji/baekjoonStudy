import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(br.readLine().trim());
    	for(int i = 0;i<T;i++) {
    		int N = Integer.parseInt(br.readLine().trim());
    		String[] line = br.readLine().trim().split(" ");
    		int[] edges = new int[N+1];
    		for(int initEdges = 0;initEdges<N;initEdges++) {
    			edges[initEdges+1] = Integer.parseInt(line[initEdges]);
    		}
    		boolean[] nodes = new boolean[N+1];
    		int start = 0;
    		int result = 0;
    		for(int j = 1;j<=N;j++) {
    			if(nodes[j]) {
    				continue;
    			}
    			nodes[j] = true;
    			start = j;
    			int idx = edges[j];
    			while(idx != start) {
    				nodes[idx] = true;
    				idx = edges[idx];
    			}
    			result++;
    		}
    		System.out.println(result);
    	}
    }
}
