import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().trim().toCharArray();
        int n = str.length;

        int aCount = 0;
        for (char c : str) {
            if (c == 'a') aCount++;
        }

        if (aCount == 0 || aCount == n) {
            System.out.println(0);
            return;
        }

        int bCount = 0;
        for (int i = 0; i < aCount; i++) {
            if (str[i] == 'b') bCount++;
        }
        int min = bCount;

        for (int i = 1; i < n; i++) {
            if (str[(i - 1) % n] == 'b') bCount--; 
            if (str[(i + aCount - 1) % n] == 'b') bCount++; 
            min = Math.min(min, bCount);
        }

        System.out.println(min);
    }
}
