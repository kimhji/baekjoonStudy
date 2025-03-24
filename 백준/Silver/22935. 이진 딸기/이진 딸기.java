import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for(int t = 0;t<T;t++){
            int N = Integer.parseInt(br.readLine().trim())-1;
            N %= 28;
            N++;
            if (16 <= N) N = 30 - N;
            String result = "";
            for(int i = 0;i<4;i++){
                if(N%2 == 1){
                    result = "딸기"+result;
                }
                else{
                    result = "V"+result;
                }
                N /= 2;
            }    
            System.out.println(result);
        }
    }
}
