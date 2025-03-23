import java.util.*;
import java.io.*;

class IceCream{
	int number;
	HashSet<IceCream> noMatchIceCream = new HashSet<IceCream>();
	IceCream(int number) {
		this.number = number;
	}
	public void putNoMatch(IceCream one) {
		noMatchIceCream.add(one);
	}
	
	boolean canMatch(IceCream one) {
		return !noMatchIceCream.contains(one);
	}
}

public class Main{
	static int count = 0;
	static IceCream[] ICs;
	
	public static void dfs(int c, int idx, int N, IceCream[] bag) {
		if (c==3) {
			count++;
			return;
		}
		for(int i = idx; i<N;i++) {
			boolean isOkay = true;
			for(IceCream before: bag) {
				if(before == null) continue;
				if(!before.canMatch(ICs[i])) {
					isOkay = false;
					break;
				}
			}
			if(!isOkay) continue;
			bag[c] = ICs[i];
			dfs(c+1, i+1, N, bag);
			bag[c] = null;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().trim().split(" ");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);
		
		ICs = new IceCream[N];
		for(int i = 0;i<N;i++) {
			ICs[i] = new IceCream(i);
		}
		
		for(int i = 0;i<M;i++) {
			line = br.readLine().trim().split(" ");
			int one = Integer.parseInt(line[0])-1;
			int two = Integer.parseInt(line[1])-1;
			
			ICs[one].putNoMatch(ICs[two]);
			ICs[two].putNoMatch(ICs[one]);
		}
		IceCream[] tnsIcs = new IceCream[3];
		dfs(0, 0, N, tnsIcs);
		System.out.print(count);
	}
}