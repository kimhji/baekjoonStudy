import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        Dice[] dices = new Dice[N];
        for(int i = 0;i<N;i++){
            dices[i] = new Dice(br.readLine());
        }
        int maxV = 0;
        for(int i = 0;i<6;i++){
            int floor = dices[0].numbers[i];
            int ceil = dices[0].numbers[Dice.getOppo(i)];
            int tnsV = 0;
            for(int j = 0;j<N;j++){
                int f_idx = dices[j].findIdx(ceil);
                floor = dices[j].numbers[f_idx];
                ceil = dices[j].numbers[Dice.getOppo(f_idx)];
                int max = 0;
                for(int k = 0;k<6;k++){
                    if(dices[j].numbers[k] != floor && dices[j].numbers[k] != ceil){
                        if(max < dices[j].numbers[k]) max = dices[j].numbers[k];
                    }
                }
                tnsV += max;
            }
            if(maxV < tnsV) maxV = tnsV;
        }
        System.out.println(maxV);
    }
}

class Dice{
    int[] numbers;
    Dice(String line){
        numbers = new int[6];
        String[] dataStr = line.trim().split(" ");
        for(int i = 0;i<6;i++){
            numbers[i] = Integer.parseInt(dataStr.length>i?dataStr[i]:"0");
        }
    }   
    static int getOppo(int idx){
        switch(idx){
            case 0:
            return 5;
            case 1:
            return 3;
            case 2:
            return 4;
            case 3:
            return 1;
            case 4:
            return 2;
            case 5:
            return 0;
        }
        return 0;
    }

    int findIdx(int value){
        for(int i = 0;i<6;i++){
            if(numbers[i] == value) return i;
        }
        return 0;
    }
}