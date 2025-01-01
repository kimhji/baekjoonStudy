import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] wordArr = (br.readLine().trim().toCharArray());
		int N = wordArr.length;
		char result = 0;
		for(int i = 0;i<N;i++) {
			if(wordArr[i]>='A' && wordArr[i]<='Z') {
				result = (char) (wordArr[i]-'A'+'a');
			}
			else {
				result = (char) (wordArr[i]-'a'+'A');
			}
		System.out.print(result);
		}
	}
}