import java.util.*;
import java.io.*;


public class Main{	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<LinkedList<Integer>> stars = new ArrayList<LinkedList<Integer>>();
        
        for(int i = 0;i<12;i++) {
        	stars.add(new LinkedList<Integer>());
        }
        for(int i = 0;i<12;i++) {
        	String[] inputs = br.readLine().trim().split(" ");
        	int one = Integer.parseInt(inputs[0])-1;
        	int two = Integer.parseInt(inputs[1])-1;
        	
        	stars.get(one).add(two);
        	stars.get(two).add(one);
        }
        
        for(int i = 0;i<12;i++) {
        	if(stars.get(i).size()!=3) continue;
        	boolean isOneEdge = false;
        	boolean isTwoEdge = false;
        	boolean isThreeEdge = false;
        	for(Integer oppo:stars.get(i)) {
        		if(stars.get(oppo).size() == 1) {
        			isOneEdge = true;
        		}
        		else if(stars.get(oppo).size() == 2) {
        			isTwoEdge = true;
        		}
        		else if(stars.get(oppo).size() == 3) {
        			isThreeEdge = true;
        		}
        	}
        	if(isOneEdge && isTwoEdge && isThreeEdge) {
        		System.out.print(i+1);
        		break;
        	}
        }
        
    }
}