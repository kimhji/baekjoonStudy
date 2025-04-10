import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        String result = "";
        int N = line.length();
        int num = N;
        int disappeared_0 = 0;
        int disappeared_1 = 0;
        
        for(int cycle = 0;cycle<num;cycle++){
            if(line.charAt(cycle) == '1' && disappeared_1 < N/4){
                disappeared_1++;
                continue;
            }
            result += line.charAt(cycle);
        }
        line = result;
        result = "";
        num = line.length();
        for(int cycle = num-1;cycle>=0;cycle--){
            if(line.charAt(cycle) == '0' && disappeared_0 < N/4){
                disappeared_0++;
                continue;
            }
            result = line.charAt(cycle) + result;
        }
        System.out.print(result);
    }
}