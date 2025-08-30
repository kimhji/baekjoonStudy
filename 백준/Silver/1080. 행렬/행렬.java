import java.io.*;

class Main {
    public static void change(char[][] data, int i, int j){
        for(int ch_i = 0;ch_i<3;ch_i++){
            for(int ch_j = 0;ch_j<3;ch_j++){
                data[i+ch_i][j+ch_j] = (data[i+ch_i][j+ch_j]=='0'?'1':'0');
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        char[][] board = new char[N][];
        char [][] result = new char[N][];
        for(int i = 0;i<N;i++){
            board[i] = br.readLine().trim().toCharArray();
        }
        for(int i = 0;i<N;i++){
            result[i] = br.readLine().trim().toCharArray();
        }
        int resultData = 0;
        for(int check_r = 0;check_r<N-2;check_r++){
            for(int check_c = 0;check_c<M-2;check_c++){
                if(board[check_r][check_c] != result[check_r][check_c]){
                    Main.change(board, check_r, check_c);
                    resultData++;
                }
            }
        }

        for(int check_r = 0;check_r<N;check_r++){
            for(int check_c = 0;check_c<M;check_c++){
                if(board[check_r][check_c] != result[check_r][check_c]){
                    resultData = -1;
                    break;
                }
            }
            if(resultData<0) break;
        }
        System.out.println(resultData);
    }
}