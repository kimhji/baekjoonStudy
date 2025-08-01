import java.io.*;
import java.util.*;

class Main{
	static double result = -1;
	public static double getSize(int[] vector) {
		return Math.sqrt(Math.pow(vector[0], 2)+Math.pow(vector[1], 2));
	}
	
	public static void allVisitVectors(boolean[] dotVisited, int[][] dots, int N, int i, int before) {
		if(i == N/2) {
			int[] sumVector = new int[2];
			for(int j = 0;j<N;j++) {
				if(dotVisited[j]) {
					sumVector[0] -= dots[j][0];
					sumVector[1] -= dots[j][1];
				}
				else {
					sumVector[0] += dots[j][0];
					sumVector[1] += dots[j][1];
				}
			}
			double tnsR = getSize(sumVector);
			if(tnsR < result || result < 0) {
				result = tnsR;
			}
			return;
		}
		for(int j = before+1;j<N;j++) {
			if(dotVisited[j]) continue;
			dotVisited[j] = true;
			allVisitVectors(dotVisited, dots, N, i+1, j);
			dotVisited[j] = false;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int t = 0;t<T;t++) {
			result = -1;
			int N = Integer.parseInt(br.readLine().trim());
			int[][] dots = new int[N][2];
			for(int i = 0;i<N;i++) {
				String [] line = br.readLine().trim().split(" ");
				dots[i][0] = Integer.parseInt(line[0]);
				dots[i][1] = Integer.parseInt(line[1]);
			}
			
			boolean [] dotVisited = new boolean[N];
			allVisitVectors(dotVisited, dots, N, 0, -1);
			
			System.out.println(result);
		}
	}
}
