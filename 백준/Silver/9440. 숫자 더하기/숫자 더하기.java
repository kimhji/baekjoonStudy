import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().trim().split(" ");
		int N = Integer.parseInt(line[0]);
		while(N>0) {
			ArrayList<Integer> numbers = new ArrayList<Integer>();
			for(int init = 0;init<N;init++) {
				numbers.add(Integer.parseInt(line[init+1]));
			}
			numbers.sort(null);
			Integer[] arr = (Integer[]) numbers.toArray(new Integer[0]);
			String num1 = "";
			String num2 = "";
			for(int tns = 0;tns<N;tns++) {
				if(arr[tns] != 0) {
					if("".compareTo(num1)==0) {
						num1 += arr[tns];
						arr[tns] = -1;
					}
					else {
						num2 += arr[tns];
						arr[tns] = -1;
						break;
					}
				}
			}
			for(int c = 0;c<N;c++) {
				if(arr[c]<0) continue;
				if(c%2 == 0) {
					num1 += arr[c];
				}
				else {
					num2 += arr[c];
				}
			}
			int result = Integer.parseInt(num1)+Integer.parseInt(num2);
			System.out.println(result);
			
			line = br.readLine().trim().split(" ");
			N = Integer.parseInt(line[0]);
		}
	}
}