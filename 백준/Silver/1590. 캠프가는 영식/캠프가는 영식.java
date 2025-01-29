import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
		String[] line = br.readLine().trim().split(" ");
		int N = Integer.parseInt(line[0]);
		int first = Integer.parseInt(line[1]);
		int[][] buses = new int[N][3];
		for(int i = 0;i<N;i++) {
			line = br.readLine().trim().split(" ");
			for(int j = 0;j<3;j++) {
				buses[i][j] = Integer.parseInt(line[j]);
			}
		}
		
		int minTime = 10000000;
		for(int[] bus:buses) {
			int diff = bus[0]-first;
			if(diff>=0) {
				minTime = minTime>diff?diff:minTime;
				continue;
			}
			int number = (int) Math.ceil((double) Math.abs(diff) / bus[1]);
			if(number>=bus[2]) {
				continue;
			}
			int tnsTime = bus[0] + number*bus[1] - first;
			if(minTime>tnsTime) minTime = tnsTime;
		}
		System.out.print(minTime==10000000?-1:minTime);
    }
}
