import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for(int cycle = 0;cycle<T;cycle++) {
        	char[] line = br.readLine().trim().toCharArray();
        	int maxS = 0;
        	Stack<Character> data = new Stack();
        	for(char one : line) {
        		if(one == '[') {
        			data.add(one);
        			if(maxS < data.size()) {
        				maxS = data.size();
        			}
        		}
        		else data.pop();
        	}
        	System.out.println((int)Math.pow(2, maxS));
        }
    }
}