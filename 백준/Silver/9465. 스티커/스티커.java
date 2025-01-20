import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int t = 0;t<T;t++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[][] stickers = new int[2][N];
			int[][] dp = new int[2][N];
			String [] line;
			line = br.readLine().trim().split(" ");
			for(int i = 0;i<N;i++) {
				stickers[0][i] = Integer.parseInt(line[i]);
			}
			line = br.readLine().trim().split(" ");
			for(int i = 0;i<N;i++) {
				stickers[1][i] = Integer.parseInt(line[i]);
			}
			for(int i = 0;i<N;i++) {
				for(int j = 0;j<2;j++) {
					if(i == 0) {
						dp[j][i] = stickers[j][i];
						continue;
					}
					dp[j][i] = dp[(j+1)%2][i-1] + stickers[j][i];
					if(i>1) {
						int another = dp[(j+1)%2][i-2]<dp[j][i-2]?dp[j][i-2]:dp[(j+1)%2][i-2];
						another += stickers[j][i];
						if(dp[j][i]<another) {
							dp[j][i] = another;
						}
					}
				}
			}
			int max = Math.max(dp[0][N-1], dp[1][N-1]);
			if(N>1) {
				max = Math.max(max, dp[0][N-2]);
				max = Math.max(max, dp[1][N-2]);
			}
			System.out.println(max);
		}
	}
}