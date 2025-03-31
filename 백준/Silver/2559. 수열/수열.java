import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] line = br.readLine().trim().split(" ");
        int N = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);
        
        line = br.readLine().trim().split(" ");
        int[] board = new int[N];
        int result = 0;
        for(int init = 0 ;init<N;init++){
            int tns = Integer.parseInt(line[init]);
            if(init<K){
                result += tns;
            }
            board[init] = tns;
        }
        int tnsResult = result;
        int leftIdx = 0;
        for(int cycle = K;cycle<N;cycle++){
            tnsResult -= board[leftIdx++];
            tnsResult += board[cycle];
            if(tnsResult>result) result = tnsResult;
        }
        System.out.print(result);
    }
}