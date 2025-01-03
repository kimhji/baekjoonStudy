import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		String[] line;
		long M, N, X, Y;
		for(int i = 0;i<T;i++) {
			line = br.readLine().trim().split(" ");
			M = Integer.parseInt(line[0]);
			N = Integer.parseInt(line[1]);
			X = Integer.parseInt(line[2]);
			Y = Integer.parseInt(line[3])%N;
			long y = X;
			boolean found = false;
			do {
				if(y%N==Y) {
					found = true;
					break;
				}
				X += M;
				y += M;
			}while(y <= M*N);
			if(found) {
				System.out.println(X);
			}
			else {
				System.out.println(-1);
			}
		}
	}
}