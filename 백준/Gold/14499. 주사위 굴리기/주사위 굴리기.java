import java.io.*;


class Main {
    public static int[] move(int dir){
        int[] result = new int[]{0,0};
        switch(dir){
            case 3:
                //up side
                result[0]--;
            break;
            case 1:
                //right side
                result[1]++;
            break;
            case 4:
                //down side
                result[0]++;
            break;
            case 2:
                //left side
                result[1]--;
            break;
            default:
            break;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().trim().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int y = Integer.parseInt(line[2]);
        int x = Integer.parseInt(line[3]);
        int k = Integer.parseInt(line[4]);
        Dice dice = new Dice();

        int[][] board = new int[N][M];
        for(int i = 0;i<N;i++){
            line = br.readLine().trim().split(" ");
            for(int j = 0;j<M;j++){
                board[i][j] = Integer.parseInt(line[j]);
            }
        }

        line = br.readLine().trim().split(" ");
        for(String orderStr:line){
            int order = Integer.parseInt(orderStr);
            int[] tnsMove = Main.move(order);
            if(tnsMove[0] == 0 && tnsMove[1] == 0) continue;
            if(tnsMove[0]+y < 0 || tnsMove[0]+y >= N 
            || tnsMove[1]+x < 0 || tnsMove[1]+x >= M) continue;

            y += tnsMove[0];
            x += tnsMove[1];
            dice.turn(order);
            dice.change(board, y, x);
        }
    }
}
class Dice{
    /*
     * 0: floor
     * 1: up
     * 2: right
     * 3: down
     * 4: left
     * 5: ceil
     */
    int[] numbers = new int[6];
    Dice(){}

    void turn(int dir){
        int tns = 0;
        switch(dir){
            case 3:
                //up side
                tns = numbers[0];
                numbers[0] = numbers[1];
                numbers[1] = numbers[5];
                numbers[5] = numbers[3];
                numbers[3] = tns;
            break;
            case 1:
                //right side
                tns = numbers[0];
                numbers[0] = numbers[2];
                numbers[2] = numbers[5];
                numbers[5] = numbers[4];
                numbers[4] = tns;
            break;
            case 4:
                //down side
                tns = numbers[0];
                numbers[0] = numbers[3];
                numbers[3] = numbers[5];
                numbers[5] = numbers[1];
                numbers[1] = tns;
            break;
            case 2:
                //left side
                tns = numbers[0];
                numbers[0] = numbers[4];
                numbers[4] = numbers[5];
                numbers[5] = numbers[2];
                numbers[2] = tns;
            break;
            default:
            break;
        }
        System.out.println(numbers[5]);
    }

    void change(int[][] board, int y, int x){
        if(board[y][x] == 0){
            board[y][x] = numbers[0];
        }
        else{
            numbers[0] = board[y][x];
            board[y][x] = 0;
        }
    }
}