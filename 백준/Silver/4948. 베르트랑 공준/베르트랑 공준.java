import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine().trim());
		int[] priNumArr = new int[246913];
		boolean[] isNotPri = new boolean[246913];
		isNotPri[0] = true;
		isNotPri[1] = true;
		for(int init = 2;init<246913;init++) {
			if(isNotPri[init]) {
				priNumArr[init] = priNumArr[init-1];
				continue;
			}
			
			priNumArr[init] = priNumArr[init-1]+1;
			int tnsNum = init*2;
			while(tnsNum<246913) {
				isNotPri[tnsNum] = true;
				tnsNum += init;
			}
		}
		
		while(num>0) {
			System.out.println(priNumArr[2*num]-priNumArr[num]);
			num = Integer.parseInt(br.readLine().trim());
		}
		
	}
}
