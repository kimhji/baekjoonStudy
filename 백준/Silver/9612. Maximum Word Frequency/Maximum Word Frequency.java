import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		Map<String, Integer> countOfWord = new HashMap<String, Integer>();
		String tnsMaxStr = "A";
		for(int i = 0;i<N;i++) {
			String word = br.readLine().trim();
			countOfWord.put(word, countOfWord.getOrDefault(word, 0)+1);
			if(countOfWord.get(word)>countOfWord.getOrDefault(tnsMaxStr, 0)
					|| countOfWord.get(word)==countOfWord.getOrDefault(tnsMaxStr, 0)
					&& word.compareTo(tnsMaxStr) > 0) {
				tnsMaxStr = word;
			}
		}
		
		System.out.println(tnsMaxStr + " " + countOfWord.get(tnsMaxStr));
	}
}