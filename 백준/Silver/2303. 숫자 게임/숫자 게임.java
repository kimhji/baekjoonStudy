import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        List<Player> players = new LinkedList<Player>();
        for(int i = 0;i<N;i++){
            Player tnsPlayer = new Player(br.readLine(), i+1);
            players.add(tnsPlayer);
            tnsPlayer.getMaxValue_1();
        }
        
        Collections.sort(players);

        System.out.println(players.get(0).playerNumber);
    }
}


class Player implements Comparable<Player>{
    int[] cardNumbers = new int[5];
    int playerNumber;
    int betValue;

    Player(String line, int playerNumber){
        String[] parsed = line.trim().split(" ");
        for(int i = 0;i<5;i++){
            this.cardNumbers[i] = Integer.parseInt(parsed[i]);
        }
        this.playerNumber = playerNumber;
    }

    int getMaxValue_1(){
        int result = 0;
        for(int i = 0;i<5;i++){
            for(int j = 0;j<5;j++){
                if(i == j) continue;
                for(int k = 0;k<5;k++){
                    if(k == j || k == i)
                        continue;
                    
                    int tns = (this.cardNumbers[i]+this.cardNumbers[j]+this.cardNumbers[k])%10;
                    if(result < tns){
                        result = tns;
                    }
                }
            }
        }
        this.betValue = result;
        return result;
    }


    @Override
    public int compareTo(Player one){
        if(one.betValue != this.betValue) return one.betValue - this.betValue;

        return one.playerNumber - this.playerNumber;
    }
}