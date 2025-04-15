import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        Set <String> bag = new HashSet<String>();
        int result = 0;
        for(int i = 0;i<N;i++) {
        	String line = br.readLine().trim();
        	if("ENTER".compareTo(line) == 0) {
        		result += bag.size();
        		bag.clear();
        	}
        	else {
        		bag.add(line);
        	}
        }
		result += bag.size();
        System.out.print(result);
    }
}