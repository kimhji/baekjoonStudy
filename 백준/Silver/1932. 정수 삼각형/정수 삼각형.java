import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		String[] line; 
		int[][] data = new int[N][];
		int[][] result = new int[N][];
		for(int i = 0;i<N;i++) {
			line = br.readLine().trim().split(" ");
			data[i] = new int[line.length];
			result[i] = new int[line.length];
			for(int j = 0;j<line.length;j++) {
				data[i][j] = Integer.parseInt(line[j]);
				result[i][j] = data[i][j];
			}
		}
		
		for(int i = N-2;i>=0;i--) {
			for(int j = 0;j<data[i].length;j++) {
				result[i][j] = result[i+1][j]>result[i+1][j+1]?result[i+1][j]:result[i+1][j+1];
				result[i][j] += data[i][j];
			}
		}
		System.out.print(result[0][0]);
	}
	
}