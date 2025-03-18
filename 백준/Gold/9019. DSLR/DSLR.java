import java.util.*;
import java.io.*;

public class Main{
	public static int register(int origin, String order) {
		int num;
		String tns;
		switch(order) {
		case "D":
			return (origin*2)%10000;
		case "S":
			return (origin+9999)%10000;
		case "L":
			tns = String.valueOf(origin);
			int originL = tns.length();
			if (originL < 4) {
				tns = "0".repeat(4-originL)+tns;
			}
			num = Integer.parseInt(tns.substring(1)+tns.substring(0, 1));
			return num;
		case "R":
			tns = String.valueOf(origin);
			int originL1 = tns.length();
			if (originL1 < 4) {
				tns = "0".repeat(4-originL1)+tns;
			}
			num = Integer.parseInt(tns.substring(3, 4)+tns.substring(0, 3));
			return num;
		default: return origin;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		String[] line;
		String[] orders;
		for(int c =0;c<T;c++) {
			orders = new String[10000];
			LinkedList<Integer> bag = new LinkedList<Integer>();
			line = br.readLine().trim().split(" ");
			int start =Integer.parseInt(line[0]);
			int result = Integer.parseInt(line[1]);
			orders[start] = "";
			bag.add(start);
			int nextBagLen;
			do {
				nextBagLen = 0;
				Object[] ints= bag.toArray();
				bag.clear();
				for(Object inte : ints) {
					int realNum = (int)(inte);
					String str = orders[realNum];
					String tnsOrder = str+"D";
					int D = register(realNum, "D");
					if(orders[D] == null) {
						if(D==result) {
							System.out.println(tnsOrder);
							nextBagLen = 0;
							break;
						}
						bag.add(D);
						orders[D] = tnsOrder;
						nextBagLen++;
					}
					tnsOrder = str+"S";
					int S = register(realNum, "S");
					if(orders[S] == null) {
						if(S==result) {
							System.out.println(tnsOrder);
							nextBagLen = 0;
							break;
						}
	
						bag.add(S);
						orders[S] = tnsOrder;
						nextBagLen++;
					}
					tnsOrder = str+"L";
					int L = register(realNum, "L");
					if(orders[L] == null) {
						if(L==result) {
							System.out.println(tnsOrder);
							nextBagLen = 0;
							break;
						}
	
						bag.add(L);
						orders[L] = tnsOrder;
						nextBagLen++;
					}
					tnsOrder = str+"R";
					int R = register(realNum, "R");
					if(orders[R] == null) {
						if(R==result) {
							System.out.println(tnsOrder);
							nextBagLen = 0;
							break;
						}
						bag.add(R);
						orders[R] = tnsOrder;
						nextBagLen++;
					}
				}
			}while(nextBagLen>0);
		}
	}
}