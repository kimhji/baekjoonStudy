import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int G = Integer.parseInt(br.readLine().trim());

        long S = 1;
        long E = 2;
        List<Long> result = new LinkedList<Long>();

        while(Math.pow(E, 2) - Math.pow(S, 2) <= G || E != S+1){
            if(Math.pow(E, 2) - Math.pow(S, 2) < G) E++;
            else if(Math.pow(E, 2) - Math.pow(S, 2) > G) S++;
            else{
                result.add(E);
                E++;
            }
        }
        Collections.sort(result);
        for(Long r : result){
            System.out.println(r);
        }
        if(result.size() == 0){
            System.out.println(-1);
        }
    }
}