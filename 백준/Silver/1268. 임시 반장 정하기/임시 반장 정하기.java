import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] datas = new int[n][5];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                datas[i][j] = sc.nextInt();
            }
        }

        int[][] students = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < n; k++) {
                    if (datas[i][j] == datas[k][j]) {
                        students[i][k] = 1;
                    }
                }
            }
        }

        int[] answers = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (students[i][j] == 1) count++;
            }
            answers[i] = count;
        }

        int max = 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (answers[i] > max) {
                max = answers[i];
                idx = i;
            }
        }

        System.out.println(idx + 1);
        sc.close();
    }
}
