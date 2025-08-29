import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String[] line = br.readLine().trim().split(" ");
        int M = Integer.parseInt(line[0]);
        int K = Integer.parseInt(line[1]);
        int needPen = M*K;

        int[] hasPen = new int[N];
        line = br.readLine().trim().split(" ");
        for(int i = 0;i<N;i++){
            hasPen[i] = Integer.parseInt(line[i]) * -1;
        }
        Arrays.sort(hasPen);
        int result = 0;
        int curPen = 0;

        while(curPen<needPen){
            curPen += hasPen[result++] *(-1);
            if(result>=N) break;
        }
        if(curPen<needPen)
            System.out.println("STRESS");
        else
            System.out.println(result);
    }
}