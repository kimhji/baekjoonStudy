import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        long[] cities = new long[N];
        long[] edges = new long[N-1];
        String[] line = br.readLine().trim().split(" ");
        for(int init = 0;init<N-1;init++){
            edges[init] = Long.parseLong(line[init]);
        }
        line = br.readLine().trim().split(" ");
        for(int init = 0;init<N;init++){
            long val = Long.parseLong(line[init]);
            if(init > 0) {
                if(val>cities[init-1]) val = cities[init-1];
            }
            cities[init] = val;
        }
        long result = 0;
        for(int init = 0;init<N-1;init++){
            result += edges[init] * cities[init];
        }
        System.out.print(result);
    }
}