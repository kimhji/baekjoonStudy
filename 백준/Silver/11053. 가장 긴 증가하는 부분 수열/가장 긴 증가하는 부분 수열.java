import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[] data = new int[N];
		String[] line = br.readLine().trim().split(" ");
		for(int i = 0;i<N;i++) {
			data[i]=Integer.parseInt(line[i]);
		}
		Queue<Integer[]> bag = new LinkedList<Integer[]>();
		for(int i = 0;i<N;i++) {
			boolean isMin = true;
			int maxV = 1;
			for(Integer[] value: bag) {
				if(value[0]< data[i]) {
					if(maxV<value[1]) {
						maxV = value[1];
					}
					isMin = false;
				}
			}
			if(isMin) {
				Integer[] value = {data[i],1};
				bag.add(value);
			}
			else {
				Integer[] value = {data[i],maxV+1};
				bag.add(value);
			}
		}
		int result = 0;
		for(Integer[] value: bag) {
			if(value[1]> result) {
				result = value[1];
			}
		}
		System.out.print(result);
	}
	
}