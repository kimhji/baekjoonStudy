import java.io.*;

class Main {
    static int N;
    static int M;
    public static int getSizeOfLoaf(char[][] board, char standard, int number, int y, int x){
        int result = number;
        if(y>0 && board[y-1][x] == standard) {
            result++;
            board[y-1][x] = 'v';
            result = getSizeOfLoaf(board, standard, result, y-1, x);
        }
        if(y<N-1 && board[y+1][x] == standard) {
            result++;
            board[y+1][x] = 'v';
            result = getSizeOfLoaf(board, standard, result, y+1, x);
        }
        if(x>0 && board[y][x-1] == standard) {
            result++;
            board[y][x-1] = 'v';
            result = getSizeOfLoaf(board, standard, result, y, x-1);
        }
        if(x<M-1 && board[y][x+1] == standard) {
            result++;
            board[y][x+1] = 'v';
            result = getSizeOfLoaf(board, standard, result, y, x+1);
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] argStr = br.readLine().trim().split(" ");
        M = Integer.parseInt(argStr[0]);
        N = Integer.parseInt(argStr[1]);

        int B = 0;
        int W = 0;
        char[][] board = new char[N][M];
        for(int i = 0;i<N;i++){
            board[i] = br.readLine().trim().toCharArray();
        }
        for(int i = 0;i<N;i++){
            for(int j = 0;j<M;j++){
                if(board[i][j] != 'W' && board[i][j] != 'B') continue;
                char stan = board[i][j];
                board[i][j] = 'v';
                int size = getSizeOfLoaf(board, stan, 1, i, j);
                if(stan == 'W'){
                    W += size*size;
                }
                else if(stan == 'B'){
                    B += size*size;
                }
            }
        }
        System.out.println(W+" "+B);
    }
}