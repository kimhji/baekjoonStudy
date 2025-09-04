import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        
        char[] charArr = br.readLine().trim().toCharArray();
        if(charArr[0] == 'B' || charArr[N-1] == 'A') System.out.println("No");
        else System.out.println("Yes");
    }
}