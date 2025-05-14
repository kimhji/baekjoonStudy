import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        Set<String> rainbow = new HashSet<>();
        rainbow.add("ChongChong");
        String[] line;
        for(int cycle = 0;cycle<N;cycle++){
            line = br.readLine().trim().split(" ");
            if(rainbow.contains(line[0])){
                rainbow.add(line[1]);
            }
            else if(rainbow.contains(line[1])){
                rainbow.add(line[0]);
            }
        }
        System.out.println(rainbow.size());
    }
}