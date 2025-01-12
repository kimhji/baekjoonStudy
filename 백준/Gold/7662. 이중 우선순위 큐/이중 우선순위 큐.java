import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for(int t = 0;t<T;t++) {
			int k = Integer.parseInt(br.readLine().trim());
			TreeMap<Integer, Integer> tree = new TreeMap<Integer,Integer>();
			for(int i = 0;i<k;i++) {
				String[] line = br.readLine().trim().split(" ");
				switch(line[0]) {
					case "I":
						Integer data = Integer.parseInt(line[1]);
						tree.put(data, tree.getOrDefault(data, 0)+1);
						break;
					case "D":
						if(!tree.isEmpty()) {
							if(Integer.parseInt(line[1])>0) {
								Integer max = tree.lastKey();
								if(tree.get(max) <= 1) {
									tree.remove(max);
								}
								else {
									tree.put(max, tree.getOrDefault(max, 0)-1);
								}
							}
							else {
								Integer min = tree.firstKey();
								if(tree.get(min) <= 1) {
									tree.remove(min);
								}
								else {
									tree.put(min, tree.getOrDefault(min, 0)-1);
								}							
							}
						}
						break;
				}
			}
			if(tree.isEmpty()) {
				System.out.println("EMPTY");
			}
			else {
				Integer maxV = tree.lastKey();
				Integer minV = tree.firstKey();
				System.out.printf("%d %d\n", maxV, minV);
			}
		}
	}
	
}