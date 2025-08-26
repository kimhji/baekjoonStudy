import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] rooms = new int[N];
        String[] r_strs = br.readLine().trim().split(" ");
        for(int i = 0;i<N;i++){
            rooms[i] = Integer.parseInt(r_strs[i]);
        }
        String[] BAndC = br.readLine().trim().split(" ");
        int B = Integer.parseInt(BAndC[0]);
        int C = Integer.parseInt(BAndC[1]);
        long result = 0L;
        for(int room: rooms){
            if(room<=0) continue;

            result++;
            room -= B;

            if(room<=0) continue;

            result += room/C;
            room = room % C;

            if(room<=0) continue;
            result ++;
        }
        System.out.println(result);
    }
}