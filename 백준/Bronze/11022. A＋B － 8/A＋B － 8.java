import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String[] line;
        for(int i =1;i<=N;i++){
            line = br.readLine().trim().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            System.out.println("Case #"+i+": "+a+" + "+b+" = "+(a+b));
        }
    }
}