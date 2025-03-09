import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().trim().split(" ");
		int N = Integer.parseInt(line[0]);
		int score = Integer.parseInt(line[1]);
		int numOfRank = Integer.parseInt(line[2]);
		
		if(N>0)
			line = br.readLine().trim().split(" ");
		int result = 1;
		int loc = 1;
		for(int i = 0;i<N;i++) {
			int curScore = Integer.parseInt(line[i]);
			if(curScore>score) {
				result += 1;
				loc = i+2;
				
			}
			else if(curScore==score) {
				loc = i+2;
			}
			else {
				loc = i+1;
				break;
			}
		}
		if(loc>numOfRank) {
			result = -1;
		}
		System.out.println(result);
		
	}
}