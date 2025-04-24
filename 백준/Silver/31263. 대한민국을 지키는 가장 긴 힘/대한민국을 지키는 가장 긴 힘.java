import java.util.*;
import java.io.*;


public class Main{	
	public static boolean able(String s) {
        long num = 0;
        for (int i = 0; i < s.length(); i++) {
            num *= 10;
            num += s.charAt(i) - '0';
        }
        return num <= 641;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if ((i + 3 == N || (i + 3 < N && s.charAt(i + 3) != '0')) && able(s.substring(i, Math.min(i + 3, N)))) {
                i += 2;
            } else if ((i + 2 == N || (i + 2 < N && s.charAt(i + 2) != '0')) && able(s.substring(i, Math.min(i + 2, N)))) {
                i += 1;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}