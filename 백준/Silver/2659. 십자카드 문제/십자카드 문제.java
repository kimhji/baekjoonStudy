import java.util.*;
import java.io.*;

public class Main{
	public static String clockNumber(String A) {
		String result = A;
		int curV = Integer.parseInt(A);
		
		for(int i = 0;i<4;i++) {
			String tnsResult = A.substring(i) + A.substring(0, i);
			int tnsV = Integer.parseInt(tnsResult);
			if(curV>tnsV) {
				result = tnsResult;
				curV  =tnsV;
			}
		}
		return result;
	}
	
	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().trim().split(" ");
        String input = inputs[0]+inputs[1]+inputs[2]+inputs[3];
        String inputClockNumber = clockNumber(input);
        Set<Integer> bag = new HashSet<Integer>();
        int inputV = Integer.parseInt(inputClockNumber);
        int tnsV = 0;
        for(int i1 = 1;i1<=9 && inputV > tnsV;i1++) {
        	for(int i2 = 1;i2<=9 && inputV > tnsV;i2++) {
        		for(int i3 = 1;i3<=9 && inputV > tnsV;i3++) {
        			for(int i4 = 1;i4<=9 && inputV > tnsV;i4++) {
        	        	String tnsStr = String.valueOf(i1)+ String.valueOf(i2)+String.valueOf(i3)+String.valueOf(i4);
        	        	String tnsClockNumber = clockNumber(tnsStr);
        	        	int tnsV2 = Integer.parseInt(tnsClockNumber);
        	        	if(tnsV2>tnsV) {
        	        		tnsV = tnsV2;
        	        	}
        	        	bag.add(tnsV2);
        	        }
                }
            }
        }
        System.out.print(bag.size());
    }
}