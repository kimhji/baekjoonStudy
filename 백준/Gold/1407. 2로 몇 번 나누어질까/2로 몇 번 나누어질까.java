import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] argStr = br.readLine().trim().split(" ");
        long A = Long.parseLong(argStr[0]);
        long B = Long.parseLong(argStr[1]);

        long tns_2 = 2;
        Map<Long, Long> data = new HashMap<Long, Long>();

        while(tns_2 <= B){
            //System.out.println(tns_2);
            long count = (B / tns_2) - ((A - 1) / tns_2);
            data.put(tns_2, count);
            tns_2 *= 2;
            //System.out.println();
        }
        long result = 0L;
        while(tns_2>1){
            //System.out.println(count+" "+tns_2);
            result += (data.getOrDefault(tns_2, 0L)
                        - data.getOrDefault(tns_2*2, 0L))*tns_2;
            tns_2 /= 2;
        }
        //System.out.println(data.getOrDefault(2L, new HashSet<Long>()).size());
        result += B-A - data.getOrDefault(2L, 0L) + 1;
        System.out.println(result);
    }
}