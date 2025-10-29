import java.io.*;
import java.util.*;

class Main {
    public static Map<Integer, Long> numbers = new HashMap<Integer, Long>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        numbers.put(Integer.valueOf(0), Long.valueOf(1L));
        long result = getT(N);
        System.out.println(result);
    }
    public static Long getT(Integer n){
        if(numbers.getOrDefault(n, null) != null){
            return numbers.get(n);
        }

        long result = 0L;
        for(int i = 0;i<n;i++){
            result += getT(i)*getT(n-i-1);
        }
        numbers.put(n, result);
        return result;
    }
}