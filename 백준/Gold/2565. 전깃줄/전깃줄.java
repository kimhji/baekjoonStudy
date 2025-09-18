import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        ElectricLine[] lines = new ElectricLine[N];
        for(int i = 0;i<N;i++){
            String[] argsStr = br.readLine().trim().split(" ");
            lines[i] = new ElectricLine(Integer.parseInt(argsStr[0]), Integer.parseInt(argsStr[1]));
        }
        Arrays.sort(lines);
        int[] numbers = new int[N];
        int result = 0;
        for(int i = 0;i<N;i++){
            numbers[i] = 1;
            for(int j = i-1;j>=0;j--){
                if(lines[i].end > lines[j].end){
                    numbers[i] = Math.max(numbers[i], numbers[j] + 1);
                }
            }
            if(result < numbers[i]) result = numbers[i];

        }

        System.out.println(N-result);
    }
}

class ElectricLine implements Comparable<ElectricLine>{
    int start;
    int end;
    ElectricLine(int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(ElectricLine one){
        return this.start - one.start;
    }
}