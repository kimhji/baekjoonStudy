import java.util.*;
import java.io.*;

class Graph implements Comparable<Graph> {
	int height;
	int idx;
	Graph(int height, int idx){
		this.height = height;
		this.idx = idx;
	}
	

	@Override
	public int compareTo(Graph o) {
		return o.idx - this.idx;
	}
}

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        Graph[] arr = new Graph[N];
        for(int cycle = 0;cycle<N;cycle++) {
        	String[] line = br.readLine().trim().split(" ");
        	int idx = Integer.parseInt(line[0]);
        	int height = Integer.parseInt(line[1]);
        	arr[cycle] = new Graph(height, idx);
        }
        Arrays.sort(arr);
        int maxh = 0;
        int maxIdx = -1;
        for(int cycle = 0;cycle<N;cycle++) {
        	if(arr[cycle].height>maxh) {
        		maxIdx = cycle;
        		maxh = arr[cycle].height;
        	}
        }
        Deque<Graph> box = new LinkedList<Graph>();
        box.add(arr[maxIdx]);
        int result = arr[maxIdx].height;
        int firstIdx = maxIdx-1;
        while(firstIdx>=0) {
        	Graph compG = box.peekFirst();
        	while(compG!=null && compG.height<arr[firstIdx].height) {
        		box.removeFirst();
            	compG = box.peekFirst();
        	}
        	box.addFirst(arr[firstIdx--]);
        }
        int lastIdx = maxIdx+1;
        while(lastIdx<N) {
        	Graph compG = box.peekLast();
        	while(compG!=null && compG.height<arr[lastIdx].height) {
        		box.removeLast();
        		compG = box.peekLast();
        	}
        	box.addLast(arr[lastIdx++]);
        }
        
        Graph tns = box.pollFirst();
        while(tns.idx>arr[maxIdx].idx) {
        	result += tns.height * (tns.idx - box.peekFirst().idx);
        	
        	tns = box.pollFirst();
        }
        box.addFirst(tns);
        tns = box.pollLast();
        while(tns.idx<arr[maxIdx].idx) {
        	result += tns.height * (box.peekLast().idx - tns.idx);
        	tns = box.pollLast();
        }
        System.out.println(result);
    }
}