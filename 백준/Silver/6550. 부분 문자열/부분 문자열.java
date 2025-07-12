import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		while(line!=null) {
			String[] twoStr = line.trim().split(" ");
			char[] sub = twoStr[0].toCharArray();
			char[] standard = twoStr[1].toCharArray();
			int i = 0;
			int j = 0;
			while(i<sub.length && j<standard.length) {
				if(sub[i] == standard[j]) {
					i++;
				}
				j++;
			}

			if(i == sub.length) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
			
			line = br.readLine();
		}
	}

}
