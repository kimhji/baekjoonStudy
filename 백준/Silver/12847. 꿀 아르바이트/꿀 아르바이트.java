import java.util.*;
import java.io.*;


public class Main{	
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().trim().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);
        inputs = br.readLine().trim().split(" ");
        int[] money = new int[N];
        for(int init = 0;init<N;init++) {
        	money[init] = Integer.parseInt(inputs[init]);
        }
        Long maxValue = 0L;
        Long tnsV = 0L;
        for(int i = 0;i<N;i++) {
        	if(i<M) {
        		maxValue += money[i];
        		tnsV = maxValue;
        		continue;
        	}
        	tnsV = tnsV + money[i] - money[i-M];
        	if(maxValue < tnsV) maxValue = tnsV;
        }
        System.out.println(maxValue);
    }
}