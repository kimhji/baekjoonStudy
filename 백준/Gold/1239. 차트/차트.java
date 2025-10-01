import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        char[] data = new char[N];
        String[] argStr = br.readLine().trim().split(" ");
        char[] order = new char[N];
        boolean[] visited = new boolean[N];
        for(int i = 0;i<N;i++){
            order[i] = (char)-1;
            data[i] = (char)Integer.parseInt(argStr[i]);
        }
        int result = findMaxLine(N, data, order, 0, visited);
        System.out.println(result);
    }
    public static int findMaxLine(int N, char[] values, char[] order, int visit, boolean[] visited){
        if(visit == N){
            return findLine(N, values, order);
        }
        int result = 0;
        for(int i = 0;i<N;i++){
            if(visited[i]) continue;
            order[visit] = (char)i;
            visited[i] = true;
            result = Math.max(findMaxLine(N, values, order, visit+1, visited), result);
            order[visit] = (char)-1;
            visited[i] = false;
        }
        return result;
    } 

    public static int findLine(int N, char[] values, char[] order){
        int line = 0;
        for(int i = 0;i<N;i++){
            int sum = 0;
            for(int j = 0;j<N;j++){
                sum += values[order[(i+j)%N]];
                if(sum == 50){
                    line++;
                }
            }
        }
        return line/2;
    }
}