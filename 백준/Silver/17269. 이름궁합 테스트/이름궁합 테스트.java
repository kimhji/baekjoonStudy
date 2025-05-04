import java.util.*;
import java.io.*;


public class Main{	
	public static void changeCharToInt(char[] ch, int[] in) {
		int idx = 0;
		for(char one:ch) {
			switch(one) {
			case 'E':
				in[idx] = 4;
				break;
			case 'A', 'F', 'H', 'K','M':
				in[idx] = 3;
				break;
			case 'B', 'D', 'N', 'P','Q','R','T','X','Y':
				in[idx] = 2;
				break;
			default:
				in[idx] = 1;
				break;
			}
			idx++;
		}
	}
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().trim().split(" ");
        
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);
        inputs = br.readLine().trim().toUpperCase().split(" ");
        
        char[] oneC = inputs[0].toCharArray();
        char[] twoC = inputs[1].toCharArray();
        
        int[] one = new int[a];
        int[] two = new int[b];
        changeCharToInt(oneC, one);
        changeCharToInt(twoC, two);
        Deque<Integer> total = new LinkedList<Integer>();
        int totalL = a+b;
        int idx_a = 0;
        int idx_b = 0;
        
        while(idx_a<a&&idx_b<b) {
        	total.add(one[idx_a++]);
        	total.add(two[idx_b++]);
        }
        while(idx_a<a) {
        	total.add(one[idx_a++]);
        }
        while(idx_b<b) {
        	total.add(two[idx_b++]);
        }
        
        while(totalL>2) {
        	Deque<Integer> nextTotal = new LinkedList<Integer>();
        	int nextTotalL = 0;
        	int pre = total.pollFirst();
        	int tns = 1;
        	while(tns<totalL) {
        		tns++;
        		int cur = total.pollFirst();
        		nextTotal.add((cur+pre)%10);
        		pre = cur;
        		nextTotalL++;
        	}
        	
        	totalL = nextTotalL;
        	total = nextTotal;
        }
        int resultInt = total.pollFirst()*10+total.pollFirst();
        String result = String.valueOf(resultInt)+"%";
        System.out.print(result);
	}
    
}