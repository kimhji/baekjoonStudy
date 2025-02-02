import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine().trim());
    	int [] seniors = new int[N+1]; 
    	for(int i =1;i<=N;i++) {
    		seniors[i] = Integer.parseInt(br.readLine().trim());
    	}
    	int maxCount = 0;
    	int maxIdx = 0;
    	for(int i =1;i<=N;i++) {
    		boolean[] visited = new boolean[N+1];
    		int cur = i;
    		int count = 0;
    		while(!visited[cur]) {
    			count++;
    			visited[cur] = true;
    			cur = seniors[cur];
    		}
    		if(maxCount<count) {
    			maxCount = count;
    			maxIdx = i;
    		}
    	}
    	System.out.print(maxIdx);
    }
}
