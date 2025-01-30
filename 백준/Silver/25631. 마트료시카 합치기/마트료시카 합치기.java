import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine().trim());
		String[] line = br.readLine().trim().split(" ");
		Map<Integer, Integer> data = new HashMap<Integer, Integer>();
		int maxV = 0;
		for(String one : line) {
			int num = Integer.parseInt(one);
			if(data.containsKey(num)) {
				data.put(num, data.get(num)+1);
			}
			else {
				data.put(num, 1);
			}
			if(maxV<data.get(num)) {
				maxV = data.get(num);
			}
		}
		System.out.print(maxV);
    }
}
