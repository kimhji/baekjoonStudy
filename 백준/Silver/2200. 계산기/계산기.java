import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim())+1;
		String[] inputs = br.readLine().trim().split(" ");
		int result = 2;
		for(int i = 1;i<N-1;i++) {
			if(Integer.parseInt(inputs[i])>0) {
				result += inputs[i].length()+1;
			}
			result += 2;
		}
		if(Integer.parseInt(inputs[N-1])>0) {
			result += inputs[N-1].length()+1;
		}
		System.out.print(result);
	}

}
