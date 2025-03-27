import java.util.*;
import java.io.*;

class Party{
	boolean[] comePeople;
	boolean isOkay = true;
	Party(int N){
		comePeople = new boolean[N];
	}
}
class Person{
	LinkedList<Integer> goParty = new LinkedList<Integer>();
	boolean knowTruth = false;
}

public class Main{
	static int N, M;
	static boolean dfs(Party[] parties, Person[] people) {
		boolean isUpdated = false;
		for(Person one : people) {
			if(!one.knowTruth) continue;
			for(int go: one.goParty) {
				if(parties[go].isOkay) {
					isUpdated = true;
					parties[go].isOkay = false;
					for(int idx = 0;idx<N;idx++) {
						if(parties[go].comePeople[idx])people[idx].knowTruth = true;
					}
				}
			}
		}
		return isUpdated;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] line = br.readLine().trim().split(" ");
		
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		Party[] parties = new Party[M];
		Person[] people = new Person[N];
		for(int init = 0;init<N;init++) {
			people[init] = new Person();
		}
		
		line = br.readLine().trim().split(" ");
		int knowNum = Integer.parseInt(line[0]);
		for(int know = 1;know<=knowNum;know++) {
			int idx = Integer.parseInt(line[know])-1;
			people[idx].knowTruth = true;
		}

		for(int init = 0;init<M;init++) {
			parties[init] = new Party(N);
			line = br.readLine().trim().split(" ");
			int num = Integer.parseInt(line[0]);
			for(int p = 1;p<=num;p++) {
				int idx = Integer.parseInt(line[p])-1;
				parties[init].comePeople[idx] = true;
				people[idx].goParty.add(init);
			}
		}
		boolean repeat = true;
		while(repeat) {
			repeat = dfs(parties, people);
		}
		int count =0;
		for(int cycle = 0;cycle<M;cycle++) {
			if(parties[cycle].isOkay) count++;
		}
		System.out.print(count);
	}
}