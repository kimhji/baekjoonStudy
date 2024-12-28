import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static int[] fruits;
	public static void main(String[] args) throws IOException {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(sc.readLine());
		fruits = new int[N];
		
		String[] line = sc.readLine().trim().split(" ");
		for(int i =0;i<N;i++) {
			fruits[i] = Integer.parseInt(line[i]);
		}
		int first = 0;
		int last = 0;
		int maxLength = 1;
		HashMap<Integer, Integer> fruitIdx = new HashMap<>();
		Set<Integer> fruit = new HashSet<Integer>();
		while(last < N) {
			fruit.add(fruits[last]);
			if(fruit.size()>2) {
				Integer[] existFruit = fruit.toArray(new Integer[0]);
				Integer anotherFruit = -1;
				for(int i = 0;i<=2;i++) {
					if(fruits[last]!=existFruit[i] &&  fruits[first]!=existFruit[i]) {
						anotherFruit = existFruit[i];
					}
				}
				if(fruitIdx.get(fruits[first])<fruitIdx.get(anotherFruit)) {
					fruit.remove(fruits[first]);
					first = fruitIdx.get(fruits[first])+1;
				}
				else {
					fruit.remove(anotherFruit);
					first = fruitIdx.get(anotherFruit)+1;
				}
			}
			fruitIdx.put(fruits[last], last);
			int tnsLength = last-first+1;
			maxLength = maxLength<tnsLength?tnsLength:maxLength;
			last++;
		}
		System.out.print(maxLength);
	}
}
