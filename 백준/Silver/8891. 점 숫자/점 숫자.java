import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	int T = Integer.parseInt(br.readLine().trim());
    	for(int i = 0;i<T;i++) {
    		String[] data = br.readLine().trim().split(" ");
    		int a = Integer.parseInt(data[0]);
    		int b = Integer.parseInt(data[1]);
    		
    		int[] one = makePos(a);
    		int[] two = makePos(b);
    		one[0] += two[0];
    		one[1] += two[1];
    		
    		int result = makeDotNumber(one[0], one[0]+one[1]-1);
    		
    		System.out.println(result);
    	}
    }
    public static int[] makePos(int dotNumber) {
    	int x = 0;
		int y = 1;
		int cur = 1;
		while(dotNumber>cur) {
			dotNumber -= cur++;
			y++;
		}
		x = dotNumber;
		y = y+ 1 - dotNumber;
		
		return new int[]{x, y};
    }
    
    public static int makeDotNumber(int x, int maxV) {
		int result = x;
		for(int j = 1;j<maxV;j++) {
			result += j;
		}
		return result;
    }
}
