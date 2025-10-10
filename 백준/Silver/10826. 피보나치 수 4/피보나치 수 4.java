import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        BigInteger f_0 = new BigInteger("0");
        BigInteger f_1 = new BigInteger("1");
        if(N==0){
            System.out.println(0);
            return;
        }
        if(N==1){
            System.out.println(1);
            return;
        }

        int idx = 1;
        while(N>idx){
            idx++;
            BigInteger tns = f_0.add(f_1);
            f_0 = f_1;
            f_1 = tns;
        }
        System.out.println(f_1);
    }
}