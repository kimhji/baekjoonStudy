
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] A = new int[31];
        int[] B = new int[31];
        for (int i = 1; i <= 30; i++) {
            A[i] = -1;
            B[i] = -1;
        }
        A[0] = 0;
        A[1] = 1;
        A[2] = 0;
        B[0] = 0;
        B[1] = 0;
        B[2] = 1;

        String[] data = br.readLine().trim().split(" ");
        int D = Integer.parseInt(data[0]);
        int K = Integer.parseInt(data[1]);

        int A_num = getArrNum(D, A);
        int B_num = getArrNum(D, B);

        int A_val = 1;
        int B_val = (int) Math.ceil((double) K / B_num);
        while (true) {
            int tns_result = A_num * A_val + B_num * B_val;
            if (tns_result == K) {
                break;
            } else if (tns_result < K) {
                A_val++;
            } else {
                B_val--;
            }
        }
        System.out.println(A_val);
        System.out.println(B_val);
    }

    public static int getArrNum(int idx, int[] dayNum) {
        if (dayNum[idx] < 0) {
            dayNum[idx] = getArrNum(idx - 1, dayNum) + getArrNum(idx - 2, dayNum);
        }
        return dayNum[idx];
    }
}
