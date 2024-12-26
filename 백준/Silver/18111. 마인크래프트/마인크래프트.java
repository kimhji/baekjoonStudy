import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = sc.readLine().trim().split(" ");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		int B = Integer.parseInt(line[2]);
		
		int [][] Board = new int[N][M];
		int average = 0;
		for(int i = 0;i<N;i++) {
			line = sc.readLine().trim().split(" ");
			for(int j = 0;j<M;j++) {
				Board[i][j] = Integer.parseInt(line[j]);
				average += Board[i][j];
			}
		}
		average = Math.floorDiv(average, N*M);
		long time = 99999999999999999l;
		long tnsTime = 99999999999999998l;
		int height = average;
		int tnsHeight = average-1;
		do {
			time = tnsTime;
			height = tnsHeight;
			tnsTime = calTime(++tnsHeight, Board, N, M ,B);
			if(tnsTime<0) break;
			if(tnsHeight>256 || tnsHeight<0) break;
		}while(time>tnsTime||time==tnsTime&&height<tnsHeight);
		
		System.out.printf("%d %d", time, height);
	}
	
	public static long calTime(int height, int[][] Board, int N,int M, int B) {
		long time = 0;
		int diff = 0;
		int totalNeedB = 0;
		for(int i = 0;i<N;i++) {
			for(int j = 0;j<M;j++) {
				diff = Board[i][j]-height;
				if(diff<0) {
					time -= diff;
				}
				else if(diff>0) {
					time += diff*2;
				}
				totalNeedB -= diff;
			}
		}
		if(totalNeedB > B) {
			return -1;
		}
		return time;
	}
}