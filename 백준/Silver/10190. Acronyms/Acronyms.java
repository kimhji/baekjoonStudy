import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for(int i = 0;i<T;i++) {
			String[] line = br.readLine().trim().split(" ");
			String data = line[0];
			int N = Integer.parseInt(line[1]);
			System.out.println(data);
			for(int j = 0;j<N;j++) {
				line = br.readLine().trim().split(" ");
				int k = 0;
				boolean print = true;
				if(line.length != data.length()) print = false;
				else {
					for(String word:line) {
						if(word.charAt(0) != data.charAt(k++)) {
							print = false;
						}
					}
				}
				if(print)
					System.out.println(String.join(" ", line));
			}
		}
	}

}
