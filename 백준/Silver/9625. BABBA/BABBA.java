import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(br.readLine().trim());
        int A = 1;
        int B = 0;
        for(int i = 0;i<N;i++){
            int tnsB = B+A;
            A = B;
            B = tnsB;
        }
        System.out.println(A+" "+B);
    }
}