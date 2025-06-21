import java.util.*;
import java.io.*;

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		HashSet<String> songTitleBook = new HashSet<String>();
		HashMap<String, Boolean> titleMap = new HashMap<String, Boolean>();
		for(int titleC = 0;titleC<N;titleC++) {
			String title = br.readLine().trim();
			titleMap.put(title, false);
			songTitleBook.add(title);
		}
		int M = Integer.parseInt(br.readLine().trim());
		int standard = (N+1)/2;
		int iStandard = 0;
		for(int titleC = 0;titleC<M;titleC++) {
			String title = br.readLine().trim();
			if(songTitleBook.contains(title) && !titleMap.get(title)) {
				titleMap.put(title, true);
				iStandard++;
			}
			if(iStandard>=standard) {
				System.out.println(titleC+1);
				break;
			}
		}
	}
}