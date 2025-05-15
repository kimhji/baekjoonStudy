import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        float [] datas = new float[N]; 
        float result = 0.0f;
        for(int i = 0;i<N;i++) {
        	float one = Float.parseFloat(br.readLine().trim());
        	datas[i] = one;
        	if(i>0 && 1 < datas[i-1])
        		datas[i] *= datas[i-1];
        	if(result < datas[i]) result = datas[i];
        }
        result = (float)Math.round(result*1000)/1000;
        System.out.printf("%.3f", result);
    }
}