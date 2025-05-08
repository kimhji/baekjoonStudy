import java.util.*;
import java.io.*;


public class Main{	
	static int N = 0;
	public static void solve(int gender, int num, int[] switches) {
		if(gender == 1) {
			manSolve(num, switches);
		}
		else womanSolve(num, switches);
	}
	private static void manSolve(int num, int[] switches) {
		for(int i = num;i<=N;i += num) {
			switches[i-1]++;
			switches[i-1] %= 2;
		}
	}
	private static void womanSolve(int num, int[] switches) {
		int size = 0;
		num--;
		while(num+size < N && num-size>=0 && switches[num+size] == switches[num - size]) {
			size++;
		}
		size--;
		for(int i = num-size;i<=num+size;i++) {
			switches[i]++;
			switches[i] %= 2;
		}
	}
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        int[] switches = new int[N];
        String[] line = br.readLine().trim().split(" ");
        for(int init = 0;init<N;init++) {
        	switches[init] = Integer.parseInt(line[init]);
        }
        int M = Integer.parseInt(br.readLine().trim());
        for(int cycle = 0;cycle<M;cycle++) {
        	line = br.readLine().trim().split(" ");
        	int gender = Integer.parseInt(line[0]);
        	int num = Integer.parseInt(line[1]);
        	solve(gender, num, switches);
        }
        for(int p = 0;p<N;p++) {
        	System.out.print(String.valueOf(switches[p]));
            if(p == N-1 || p!= 0 && (p+1)%20 == 0) System.out.println();
            else System.out.print(" ");
        }
	}
    
}