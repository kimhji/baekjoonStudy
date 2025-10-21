import java.io.*;

class Main {
    public static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().trim().split(" ");
        int sausage = Integer.parseInt(data[0]);
        int critics = Integer.parseInt(data[1]);
        int result = 0;
        
        System.out.println(critics-gcd(sausage, critics));

    }
}