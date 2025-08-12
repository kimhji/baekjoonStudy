import java.util.*;
import java.io.*;

class Nation implements Comparable<Nation>{
	int num;
	int gold = 0;
	int silver = 0;
	int bronze = 0;
	
	Nation(String[] line){
		this.num = Integer.parseInt(line[0]);
		this.gold = Integer.parseInt(line[1]);
		this.silver = Integer.parseInt(line[2]);
		this.bronze = Integer.parseInt(line[3]);
	}
	
	@Override
	public int compareTo(Nation nation) {
		if(this.gold != nation.gold) return nation.gold - this.gold;
		if(this.silver != nation.silver)return nation.silver - this.silver;
		return nation.bronze - this.bronze;
	}
}

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().trim().split(" ");
		int N = Integer.parseInt(line[0]);
		int K = Integer.parseInt(line[1]);
		LinkedList<Nation> nations = new LinkedList<Nation>();
		Nation target = null;
		for(int i = 0;i<N;i++) {
			line = br.readLine().trim().split(" ");
			Nation tns = new Nation(line);
			nations.add(tns);
			if(K == tns.num) {
				target = tns;
			}
		}
		int result = 0;
		for(Nation nation:nations) {
			if(target.compareTo(nation)>0) result++;
		}
		System.out.println(result+1);
	}

}