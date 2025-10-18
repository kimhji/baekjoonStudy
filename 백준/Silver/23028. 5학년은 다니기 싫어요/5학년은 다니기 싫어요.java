import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] argStr = br.readLine().trim().split(" ");
        int N = Integer.parseInt(argStr[0]);
        int A = Integer.parseInt(argStr[1]);
        int B = Integer.parseInt(argStr[2]);
        

        for(int i = 0;i<8-N;i++){
            argStr = br.readLine().trim().split(" ");
            int maj = Integer.parseInt(argStr[0]);
            int non = Integer.parseInt(argStr[1]);

            int add_maj = Math.min(maj, 6);
            int add_non = Math.min(non, 6-add_maj);
            A += add_maj*3;
            B += (add_maj+add_non)*3;
        }
        if(A >= 66 && B >= 130){
            System.out.println("Nice");
        }
        else{
            System.out.println("Nae ga wae");
        }
    }
}