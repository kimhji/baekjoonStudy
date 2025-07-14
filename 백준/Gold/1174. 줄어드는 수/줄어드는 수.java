import java.io.*;
import java.util.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		if(N <= 10) {
			System.out.println(N-1);
			return;
		}
		
		int curC = 10;
		LinkedList<Long> bag = new LinkedList<Long>();
		for(int i = 0;i<10;i++) {
			bag.add((long)i);
		}
		boolean flag = true;
		while(curC < N && flag) {
			flag = false;
			LinkedList<Long> nextBag = new LinkedList<Long>();
			for(Long num:bag) {
				long stand = num%10;
				for(int i = 0;i<stand;i++) {
					nextBag.add(num*10+i);
					curC++;
					if(curC == N) {
						System.out.println(num*10+i);
						return;
					}
					flag = true;
				}
			}
			bag = nextBag;
		}
		System.out.println(-1);
	}
}
