import java.io.*;
import java.util.*;

class Main {
    static int wResult[][][] = new int[21][21][21];
    static boolean visited[][][] = new boolean[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().trim().split(" ");
        int a = Integer.parseInt(data[0]);
        int b = Integer.parseInt(data[1]);
        int c = Integer.parseInt(data[2]);
        while(a != -1 || b != -1 || c != -1){
            int result = w(a, b, c);
            System.out.println(String.format("w(%d, %d, %d) = %d", a,b,c, result));


            data = br.readLine().trim().split(" ");
            a = Integer.parseInt(data[0]);
            b = Integer.parseInt(data[1]);
            c = Integer.parseInt(data[2]);
        }
    }

    public static int w(int a, int b, int c){
        if(a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }
        if(a > 20 || b > 20 || c > 20){
            return w(20, 20, 20);
        }
        if(visited[a][b][c]){
            return wResult[a][b][c];
        }

        if (a < b && b < c){
            wResult[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        }
        else{
            wResult[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        }
        visited[a][b][c] = true;
        return wResult[a][b][c];
    }
}