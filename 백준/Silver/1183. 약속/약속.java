import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine().trim());
        int[] numbers = new int[n];
        
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().trim().split(" ");
            int a = Integer.parseInt(parts[0]);
            int b = Integer.parseInt(parts[1]);
            numbers[i] = b - a;
        }
        
        Arrays.sort(numbers);
        int answer = 0;
        
        if (n % 2 == 0) {
            int start = n / 2 - 1;
            answer = numbers[start + 1] - numbers[start] + 1;
        } else {
            answer = 1;
        }
        
        System.out.println(answer);
    }
}
