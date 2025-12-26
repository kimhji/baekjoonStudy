import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] dataStr = br.readLine().trim().split(" ");

        int W = Integer.parseInt(dataStr[0]);
        int H = Integer.parseInt(dataStr[1]);
        int f = Integer.parseInt(dataStr[2]);
        int c = Integer.parseInt(dataStr[3]);
        int x1 = Integer.parseInt(dataStr[4]);
        int y1 = Integer.parseInt(dataStr[5]);
        int x2 = Integer.parseInt(dataStr[6]);
        int y2 = Integer.parseInt(dataStr[7]);

        int min_w = Math.min(W-f, f);
        long result = (long)W*H;
        if (min_w <= x1) {
			result -= (long)(x2-x1)*(y2-y1)*(c+1);
		}
		else if (min_w < x2) {
			result -= (long)(min_w-x1)*(y2-y1)*2*(c+1);
			result -= (long)(x2-min_w)*(y2-y1)*(c+1);
		}
		else {
			result -= (long)(x2-x1)*(y2-y1)*2*(c+1);
		}
        System.out.println(result);
    }   
}