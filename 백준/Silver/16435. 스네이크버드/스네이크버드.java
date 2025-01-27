import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
		String[] line = br.readLine().trim().split(" ");
		int N = Integer.parseInt(line[0]);
		int len = Integer.parseInt(line[1]);
		
		Integer[] fruits = new Integer[N];
		line = br.readLine().trim().split(" ");
		for(int i =0 ;i<N;i++) {
			fruits[i] = Integer.parseInt(line[i]);
		}
		Arrays.sort(fruits, (Integer a,Integer b) -> a-b);
		for(Integer fruit: fruits) {
			if(fruit<=len) {
				len++;
			}
		}
		System.out.print(len);
    }
}
