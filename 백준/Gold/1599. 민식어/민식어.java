import java.io.*;
import java.util.*;

class Minsik implements Comparable<Minsik>{
	String data;
	static HashMap<String, Integer> order = new HashMap<String, Integer>();
	Minsik(String str){
		this.data = str;
		initMapping();
	}
	
	void initMapping() {
		if(!order.isEmpty()) return;
		order.put("a", 0);
		order.put("b", 1);
		order.put("k", 2);
		order.put("d", 3);
		order.put("e", 4);
		order.put("g", 5);
		order.put("h", 6);
		order.put("i", 7);
		order.put("l", 8);
		order.put("m", 9);
		order.put("n", 10);
		order.put("ng", 11);
		order.put("o", 12);
		order.put("p", 13);
		order.put("r", 14);
		order.put("s", 15);
		order.put("t", 16);
		order.put("u", 17);
		order.put("w", 18);
		order.put("y", 19);
	}
	
	@Override
	public int compareTo(Minsik o) {
		int i = 0, j = 0;
		
		while(this.data.length() > i && o.data.length() > j) {
			int used = (this.data.charAt(i) == 'n' && this.data.length()>i+1 && this.data.charAt(i+1) == 'g'?2:1);
			String a = this.data.substring(i, i+used);
			i += used;
			
			used = (o.data.charAt(j) == 'n' && o.data.length()>j+1 && o.data.charAt(j+1) == 'g'?2:1);
			String b = o.data.substring(j, j+used);
			j += used;
			if(order.getOrDefault(a, 20) != order.getOrDefault(b, 20)) {
				return order.getOrDefault(a, 20) - order.getOrDefault(b, 20);
			}
		}
		return this.data.length() - o.data.length();
	}
}

class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		Minsik[] arr = new Minsik[N];
		for(int i = 0;i<N;i++) {
			arr[i] = new Minsik(br.readLine().trim());
		}
		Arrays.sort(arr);
		for(Minsik str:arr) {
			System.out.println(str.data);
		}
	}
}
