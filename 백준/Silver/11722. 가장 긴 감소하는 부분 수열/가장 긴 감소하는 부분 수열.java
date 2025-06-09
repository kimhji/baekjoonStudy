import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] maxNumOfCount = new int[N+1];
        String[] line = br.readLine().trim().split(" ");
        int result = 0;
        for(int i = 0;i<N;i++) {
        	int one = Integer.parseInt(line[i]);
        	int count = 0;
        	for(int j = i;j>0;j--) {
        		if(maxNumOfCount[j]>one) {
        			count = j;
        			break;
        		}
        	}
        	count++;
        	if(result<count) {
        		result = count;
        	}
        	if(maxNumOfCount[count]<one) {
        		maxNumOfCount[count] = one;
        	}
        }
        System.out.println(result);
    }
}