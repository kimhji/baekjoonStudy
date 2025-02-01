import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine().trim());
    	Map<String, Integer> cheeses = new HashMap<String, Integer>();
		String[] line = br.readLine().trim().split(" ");
		for(String one:line) {
			if(one.endsWith("Cheese")) {
				cheeses.put(one, cheeses.getOrDefault(one, 0)+1);
			}
		}
		if(cheeses.size()>=4) {
			System.out.print("yummy");
		}
		else {
			System.out.print("sad");
		}
    }
}
