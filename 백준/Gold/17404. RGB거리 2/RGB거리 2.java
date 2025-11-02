import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        String[] data = br.readLine().trim().split(" ");
        int[][] beforeCosts = new int[3][3];
        for(int i = 0;i<3;i++){
            beforeCosts[i][i] = Integer.parseInt(data[i]);
            beforeCosts[i][(i+1)%3] = -1;
            beforeCosts[i][(i+2)%3] = -1;
        }
        for (int i = 1; i < N; i++) {
            int[][] newCosts = new int[3][3];
            int[] costs = new int[3];
            data = br.readLine().trim().split(" ");
            for (int j = 0; j < 3; j++) {
                costs[j] = Integer.parseInt(data[j]);
                for (int k = 0; k < 3; k++) {
                    if (beforeCosts[k][(j+1)%3] < 0 && beforeCosts[k][(j+2)%3] < 0) {
                        newCosts[k][j] = -1;
                    } else if (beforeCosts[k][(j+1)%3] < 0) {
                        newCosts[k][j] = costs[j] + beforeCosts[k][(j+2)%3];
                    } else if (beforeCosts[k][(j+2)%3] < 0) {
                        newCosts[k][j] = costs[j] + beforeCosts[k][(j+1)%3];
                    } else {
                        newCosts[k][j] = costs[j] + Math.min(beforeCosts[k][(j+1)%3], beforeCosts[k][(j+2)%3]);
                    }
                }
            }
            beforeCosts = newCosts;
        }
        int result = Math.min(Math.min(Math.min(beforeCosts[0][1],beforeCosts[0][2]), Math.min(beforeCosts[1][0],beforeCosts[1][2])), Math.min(beforeCosts[2][0], beforeCosts[2][1]));
        System.out.println(result);
    }
}