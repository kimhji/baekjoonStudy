import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        if(N%2 == 1){
            System.out.println("CY");
        }
        else{
            System.out.println("SK");
        }
    }
}