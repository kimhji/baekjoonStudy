import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] argStr = br.readLine().trim().split(" ");
        int N = Integer.parseInt(argStr[0]);
        int M = Integer.parseInt(argStr[1]);

        char[][] board = new char[N][M];
        char[][] result =new char[N][M];
        for(int i = 0;i<N;i++){
            board[i] = br.readLine().trim().toCharArray();
            for(int j = 0;j<M;j++){
                result[i][j] = '.';
            }
        }

        for(int i = 0;i<N;i++){
            for(int j = 0;j<M;j++){
                if(board[i][j] != '#') continue;
                result[i][j] = '#';
                if(i<N-1){
                    result[i+1][j] = '#';
                }
                if(j<M-1){
                    result[i][j+1] = '#';
                }
                if(i<N-1){
                    result[i+1][j] = '#';
                }
                if(j<M-1 && i<N-1){
                    result[i+1][j+1] = '#';
                }
            }
        }

        for(int p1 = 0;p1<N;p1++){
            for(int p2 = 0;p2<M;p2++){
                System.out.print(result[p1][p2]);
            }
            System.out.println();
        }
    }
}