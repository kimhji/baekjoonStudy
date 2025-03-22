import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine().trim();
		int n = line.length();
		Set<String> words = new HashSet<String>();
		for(int i = 0;i<n;i++) {
			for(int j = i+1;j<=n;j++) {
				words.add(line.substring(i, j));
			}
		}
		System.out.print(words.size());
	}
}