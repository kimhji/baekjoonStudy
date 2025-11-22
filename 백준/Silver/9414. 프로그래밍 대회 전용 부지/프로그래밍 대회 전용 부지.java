
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        int currentMoney = 6 * (int) Math.pow(10, 6);
        for (int i = 0; i < T; i++) {
            List<Integer> costs = new LinkedList<>();
            int tns = Integer.parseInt(br.readLine().trim());
            while (tns != 0) {
                costs.add(tns * -1);
                tns = Integer.parseInt(br.readLine().trim());
            }
            Collections.sort(costs);
            int count = 1;
            int tnsMoney = 0;
            for (int data : costs) {
                tnsMoney += (int) Math.pow(data * -1, count++) * 2;
                if (currentMoney < tnsMoney) {
                    break;
                }
            }
            if (currentMoney < tnsMoney) {
                System.out.println("Too expensive");
            } else {
                System.out.println(tnsMoney);
            }
        }
    }
}
