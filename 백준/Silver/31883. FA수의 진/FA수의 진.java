import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int result = 0;
        for(int i = 0;i<N;i++) {
        	String[] times = br.readLine().trim().split(" ");
        	int time1 = Integer.parseInt(times[0]);
        	int time2 = Integer.parseInt(times[1]);
        	int time3_1 = Integer.parseInt(times[2]);
        	int time3_2 = Integer.parseInt(times[3]);
        	int time3 = result % (time3_1+time3_2);
        	if(time3 < time3_1) time3 = time1;
        	else time3 = time3_2 - (time3 - time3_1) + time1;
        	
        	result += time3<time2?time3:time2;
        }
        System.out.println(result);
    }
}