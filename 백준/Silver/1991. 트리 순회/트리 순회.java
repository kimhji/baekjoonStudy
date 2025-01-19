import java.io.*;
import java.util.*;

class Node{
	public char curData;
	public Node leftChild;
	public Node rightChild;
	
	public void front() {
		System.out.print(curData);
		if(leftChild != null)
			leftChild.front();
		if(rightChild != null)
			rightChild.front();
	}
	
	public void middle() {
		if(leftChild != null)
			leftChild.middle();
		System.out.print(curData);
		if(rightChild != null)
			rightChild.middle();
	}
	
	public void back() {
		if(leftChild != null)
			leftChild.back();
		if(rightChild != null)
			rightChild.back();
		System.out.print(curData);
	}
}

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		Node[] data = new Node[N];
		for(int init = 0;init<N;init++) {
			data[init] = new Node();
			data[init].curData = (char)('A'+init);
		}
		for(int i = 0;i<N;i++) {
			String[] line = br.readLine().trim().split(" ");
			if(line[1].charAt(0) != '.') {
				data[line[0].charAt(0)-'A'].leftChild = data[line[1].charAt(0)-'A'];
			}
			if(line[2].charAt(0) != '.') {
				data[line[0].charAt(0)-'A'].rightChild = data[line[2].charAt(0)-'A'];
			}
		}
		data[0].front();
		System.out.println();
		data[0].middle();
		System.out.println();
		data[0].back();
		System.out.println();
	}
}