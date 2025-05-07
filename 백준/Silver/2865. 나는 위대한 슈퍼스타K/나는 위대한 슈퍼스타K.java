import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split(" ");
        
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int K = Integer.parseInt(line[2]);
        
        float[] memberMax = new float[N];
        for(int i = 0;i<M;i++) {
        	line = br.readLine().trim().split(" ");
        	int idx = 0;
        	for(int j = 0;j<N;j++) {
        		int memIdx = Integer.parseInt(line[idx++])-1;
        		float score = Float.parseFloat(line[idx++]);
        		if(memberMax[memIdx] < score) {
        			memberMax[memIdx] = score;
        		}
        	}
        }
        
        Arrays.sort(memberMax);
        float result = 0;
        for(int i = N - K;i<N;i++) {
        	result += memberMax[i];
        }
        result = (float)(Math.round(result*10)) / 10;
        System.out.printf("%.1f", result);
    }
}