
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().trim().split(" ");
        int x_1 = Integer.parseInt(line[0]);
        int y_1 = Integer.parseInt(line[1]);
        line = br.readLine().trim().split(" ");
        int x_2 = Integer.parseInt(line[0]);
        int y_2 = Integer.parseInt(line[1]);
        line = br.readLine().trim().split(" ");
        int x_3 = Integer.parseInt(line[0]);
        int y_3 = Integer.parseInt(line[1]);

        double a_1 = (y_1 - y_2) / (double) (x_1 - x_2);
        double a_2 = (y_2 - y_3) / (double) (x_2 - x_3);
        if (a_1 == a_2) {
            System.out.println("X");
            return;
        }

        int leng_1 = (int) Math.pow((y_1 - y_2), 2) + (int) Math.pow((x_1 - x_2), 2);
        int leng_2 = (int) Math.pow((y_2 - y_3), 2) + (int) Math.pow((x_2 - x_3), 2);
        int leng_3 = (int) Math.pow((y_1 - y_3), 2) + (int) Math.pow((x_1 - x_3), 2);

        if (leng_1 == leng_2 && leng_2 == leng_3) {
            System.out.println("JungTriangle");
            return;
        }

        if (leng_1 == leng_2 || leng_1 == leng_3 || leng_2 == leng_3) {
            int maxL = 0;
            int other_1 = 0;
            int other_2 = 0;
            if (leng_1 >= leng_2 && leng_1 >= leng_3) {
                maxL = leng_1;
                other_1 = leng_2;
                other_2 = leng_3;
            } else if (leng_2 >= leng_1 && leng_2 >= leng_3) {
                maxL = leng_2;
                other_1 = leng_1;
                other_2 = leng_3;
            } else {
                maxL = leng_3;
                other_1 = leng_1;
                other_2 = leng_2;
            }

            if (maxL > other_1 + other_2) {
                System.out.println("Dunkak2Triangle");
            } else if (maxL == other_1 + other_2) {
                System.out.println("Jikkak2Triangle");
            } else {
                System.out.println("Yeahkak2Triangle");
            }
            return;
        }
        int maxL = 0;
        int other_1 = 0;
        int other_2 = 0;
        if (leng_1 >= leng_2 && leng_1 >= leng_3) {
            maxL = leng_1;
            other_1 = leng_2;
            other_2 = leng_3;
        } else if (leng_2 >= leng_1 && leng_2 >= leng_3) {
            maxL = leng_2;
            other_1 = leng_1;
            other_2 = leng_3;
        } else {
            maxL = leng_3;
            other_1 = leng_1;
            other_2 = leng_2;
        }

        if (maxL > other_1 + other_2) {
            System.out.println("DunkakTriangle");
        } else if (maxL == other_1 + other_2) {
            System.out.println("JikkakTriangle");
        } else {
            System.out.println("YeahkakTriangle");
        }
        return;
    }
}
