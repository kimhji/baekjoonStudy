import java.io.*;
import java.util.*;

class Mosquito implements Comparable<Mosquito>{
	int inTime;
	int outTime;
	Mosquito(int in, int out){
		this.inTime = in;
		this.outTime = out;
	}
	
	@Override
	public int compareTo(Mosquito o) {
		int compare = this.inTime - o.inTime;
		if(compare == 0) {
			compare = this.outTime- o.outTime;
		}
		return compare;
	}
}

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line;
		int N = Integer.parseInt(br.readLine().trim());
		Mosquito[] mosquitoes = new Mosquito[N];
		for(int i =0;i<N;i++) {
			line = br.readLine().trim().split(" ");
			int in = Integer.parseInt(line[0]);
			int out = Integer.parseInt(line[1]);
			
			mosquitoes[i] = new Mosquito(in, out);
		}
		Arrays.sort(mosquitoes);
		
		int curC = 0;
		int curT = 0;
		int maxC = 0;
		int maxT_in = 0;
		int maxT_out = 0;
		PriorityQueue<Integer> endTime = new PriorityQueue<Integer>();
		for(Mosquito mosquito: mosquitoes) {
			Integer end = endTime.peek();
			while(end != null && end <= mosquito.inTime) {
				if(curC > maxC) {
					maxC = curC;
					maxT_in = curT;
					maxT_out = end;
				}
				endTime.poll();
				curC--;
				end = endTime.peek();
			}
			curC++;
			curT = mosquito.inTime;
			if(curC == maxC && maxT_out == curT) {
				maxT_out = mosquito.outTime;
			}
			endTime.add(mosquito.outTime);
		}
		Integer end = endTime.peek();
		while(end != null) {
			if(curC > maxC) {
				maxC = curC;
				maxT_in = curT;
				maxT_out = end;
			}
			endTime.poll();
			curC--;
			end = endTime.peek();
		}
		System.out.println(maxC);
		System.out.println(maxT_in +" " + maxT_out);
	}
}
