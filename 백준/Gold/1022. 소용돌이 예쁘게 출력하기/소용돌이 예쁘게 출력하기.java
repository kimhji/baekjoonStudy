import java.io.*;

public class Main {
    public static int getValue(int r, int c) {
    int layer = Math.max(Math.abs(r), Math.abs(c));
    int len = 2 * layer + 1;
    int maxVal = len * len;

    if (r == layer) {
        return maxVal - (layer - c);
    } else if (c == -layer) {
        return maxVal - (2 * layer) - (layer - r);
    } else if (r == -layer) {
        return maxVal - (4 * layer) - (c + layer);
    } else { // c == layer
        return maxVal - (6 * layer) - (r + layer);
    }
}


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split(" ");
        int r1 = Integer.parseInt(line[0]);
        int c1 = Integer.parseInt(line[1]);
        int r2 = Integer.parseInt(line[2]);
        int c2 = Integer.parseInt(line[3]);

        int maxVal = 0;
        int[][] result = new int[r2 - r1 + 1][c2 - c1 + 1];

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                int val = getValue(i, j);
                result[i - r1][j - c1] = val;
                maxVal = Math.max(maxVal, val);
            }
        }

        int len = String.valueOf(maxVal).length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= r2 - r1; i++) {
            for (int j = 0; j <= c2 - c1; j++) {
                sb.append(String.format("%" + len + "d ", result[i][j]));
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
