import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int cycle = 0;cycle<N;cycle++){
            String animal = br.readLine().trim();
            map.put(animal, map.getOrDefault(animal, 0)+1);
        }
        boolean isAny = false;
        for(String key : map.keySet()){
            if(N-map.get(key)<map.get(key)){
                System.out.print(key);
                isAny = true;
            }
        }
        if(!isAny){
            System.out.print("NONE");
        }
    }
}