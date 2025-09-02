import java.io.*;

class Main {
    public static boolean isSame(int[] one, int length){
        for(int i = 0;i<length;i++){
            if(one[i] != i) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] tnsCard = new int[N];
        int[] nextCard = new int[N];
        int[] changeMethod = new int[N];
        int[] div = new int[N];

        String[] line = br.readLine().trim().split(" ");
        for(int i = 0;i<N;i++){
            int player = Integer.parseInt(line[i]);
            div[i] = player;
        }
        line = br.readLine().trim().split(" ");
        for(int i = 0;i<N;i++){
            changeMethod[i] = Integer.parseInt(line[i]);
            nextCard[i] = i;
        }
        boolean isOkay = false;
        int count = 0;
        do{
            isOkay = true;
            for(int i = 0;i<N;i++){
                if(i%3 != div[nextCard[i]]){
                    isOkay = false;
                    break;
                }
            }
            if(isOkay) break;
            for(int i = 0;i<N;i++){
                tnsCard[changeMethod[i]] = nextCard[i];
            }
            for(int i = 0;i<N;i++){
                nextCard[i] = tnsCard[i];
            }
            count++;
        }while(!Main.isSame(nextCard, N));

        if(isOkay){
            System.out.println(count);
        }
        else{
            System.out.println(-1);
        }
    }
}