import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(sc.readLine());
		String[] datas = sc.readLine().split(" ");
		String[] compareData = datas.clone();
		for(int i = 0;i<N-1;i++) {
			for(int j = i+1;j<N;j++) {
				if(!Main.checkTwoData(compareData[i], compareData[j])) {
					String tns = compareData[i];
					compareData[i] = compareData[j];
					compareData[j] = tns;
				}
			}
		}
		String[] result = {"",""};
		boolean KO = false;
		for(int i = 0;i<N;i++) {
			if(compareData[i]!=datas[i]) {
				if(KO) {
					result[1] = datas[i];
					break;
				}
				else {
					result[0] = datas[i];
					KO = true;
				}
			}
		}
		if(KO) {
			if(!Main.checkTwoData(result[0], result[1])) {
				String tns = result[0];
				result[0] = result[1];
				result[1] = tns;
			}
			System.out.printf("KO\n%s %s", result[0], result[1]);
		}
		else {
			System.out.print("OK");
		}
	}
	
	private static boolean checkTwoData(String one, String two) {
		char t1 = one.charAt(0);
		char t2 = two.charAt(0);
		int no1 = Integer.parseInt(one.substring(1));
		int no2 = Integer.parseInt(two.substring(1));
		if(t1==t2) {
			return no1>no2;
		}
		return !Main.IsHigherOne(t1, t2);
	}
	private static boolean IsHigherOne(char one, char two) {
		switch(one) {
		case 'B': 
			return false;
		case 'S': 
			if(two == 'B') return true;
			return false;
		case 'G': 
			if(two == 'B' || two == 'S') return true;
			return false;
		case 'P': 
			if(two != 'P' && two != 'D') return true;
			return false;
		case 'D': 
			if(two != 'D') return true;
			return false;
		default: return false;
		}
	}
	
}
