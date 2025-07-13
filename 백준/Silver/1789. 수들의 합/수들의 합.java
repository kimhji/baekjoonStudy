import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine().trim());
        
        long sum = 0;
        if(S == 1 || S == 2) {
            System.out.println(1);
            return;
        }

        for(int i=0; i<S; i++) {
            sum += i;
            if(sum > S) {
                System.out.println(i-1);
                break;
            } else if(sum == S) {
                System.out.println(i);
                break;
            }
        }
    }

}

