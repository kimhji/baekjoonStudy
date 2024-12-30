import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int count = 0;
		int idx = 0;
		
		int[] saveTnsArr = new int[N];
		initTnsArr(N, saveTnsArr);
		
		char[] line = br.readLine().trim().toCharArray();
		boolean beforeIsI = false;
		for(int i = 0;i<M;i++) {
			if(line[i] == 'I') {
				if(!beforeIsI) {
					if(saveTnsArr[idx]!=-1) {
						if(i-saveTnsArr[idx]>=2*N) {
							count++;
						}
					}
				}
				else {
					initTnsArr(N, saveTnsArr);
					idx = 0;
				}
				saveTnsArr[idx++] = i;
				idx %= N;
				beforeIsI = true;
			}
			else if(line[i] == 'O') {
				if(!beforeIsI) {
					initTnsArr(N, saveTnsArr);
					idx = 0;
				}
				beforeIsI = false;
			}
		}
		System.out.print(count);
	}
	
	public static void initTnsArr(int N, int[] tnsArr) {
		for(int i=0;i<N;i++) {
			tnsArr[i] = -1;
		}
		return;
	}
}