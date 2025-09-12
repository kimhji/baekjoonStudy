import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        Alphabet[] data = new Alphabet[10];
        char[][] lines = new char[N][];
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        boolean[] isStart0 = new boolean[10];
        for(int i = 0;i<10;i++){
            data[i] = new Alphabet((char)('A'+i));
        }
        for(int i = 0;i<N;i++){
            char[] line = br.readLine().trim().toCharArray();
            lines[i] = line;
            isStart0[line[0]-'A'] = true;
            for(int j = line.length-1;j>=0;j--){
                data[line[j]-'A'].value += Math.pow(10, line.length-1-j);
            }

        }
        Arrays.sort(data);

        long result = 0L;
        for(int i = 0;i<10;i++){
            map.put(data[i].alpha, 9-i);
        }
        int idx = 9;
        while(isStart0[data[idx].alpha-'A']){
            idx--;
        }
        for(int i = 9;i>idx;i--){
            map.put(data[i].alpha, map.get(data[i-1].alpha));
        }
        map.put(data[idx].alpha, 0);
        
        for(int i = 0;i<N;i++){
            long tns = 0L;
            for(int j = 0;j<lines[i].length;j++){
                tns *= 10;
                tns += map.get(lines[i][j]);
            }
            result += tns;
            
        }
        System.out.println(result);

    }
}

class Alphabet implements Comparable<Alphabet>{
    long value;
    char alpha;
    public Alphabet(char alpha){
        this.alpha = alpha;
        this.value = 0;
    }

    @Override
    public int compareTo(Alphabet one){
        if(one.value>this.value) return 1;
        else if(one.value == this.value) return 0;
        else return -1;
    }
}