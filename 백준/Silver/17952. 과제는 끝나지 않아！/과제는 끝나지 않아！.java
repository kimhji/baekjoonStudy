
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int result = 0;
        Stack<Integer[]> homeworks = new Stack<>();
        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().trim().split(" ");
            if (data.length > 1) {
                int score = Integer.parseInt(data[1]);
                int time = Integer.parseInt(data[2]);
                homeworks.add(new Integer[]{score, time});
            }
            if (homeworks.size() < 1) {
                continue;
            }
            Integer[] thisTime = homeworks.pop();
            thisTime[1]--;
            if (thisTime[1] <= 0) {
                result += thisTime[0]; 
            }else {
                homeworks.add(thisTime);
            }
        }
        System.out.println(result);
    }
}
