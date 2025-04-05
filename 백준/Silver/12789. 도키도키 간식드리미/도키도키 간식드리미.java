import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		String[] inputs = br.readLine().trim().split(" ");
		LinkedList<Integer> leftDatas = new LinkedList<Integer>();
		int lastGone = 0;
		for(int i = 0;i<N;i++)
		{
			int data = Integer.parseInt(inputs[i]);
			if(lastGone+1 == data) {
				lastGone = data;
				continue;
			}
			else {
				while(leftDatas.size() > 0 && lastGone+1 == leftDatas.getLast()) {
					lastGone = leftDatas.pollLast();
				}
				if(lastGone+1 == data) {
					lastGone = data;
				}
				else {
					leftDatas.add(data);
				}
			}
		}
		while(leftDatas.size() > 0 && lastGone+1 == leftDatas.getLast()) {
			lastGone = leftDatas.pollLast();
		}
		if(leftDatas.size() == 0) {
			System.out.print("Nice");
		}
		else {
			System.out.print("Sad");
		}
	}
}