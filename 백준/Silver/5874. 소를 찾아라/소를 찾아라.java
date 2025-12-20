
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().trim().toCharArray();

        boolean isBeforeOpen = false;
        boolean isFirst = true;
        int result = 0;
        int front = 0;

        for (char ch : line) {
            if (!isFirst) {
                if (ch == '(' && isBeforeOpen) {
                    front++;
                }
                if (ch == ')' && !isBeforeOpen) {
                    result += front;
                }
            }

            isFirst = false;
            if (ch == '(') {
                isBeforeOpen = true;
            } else {
                isBeforeOpen = false;
            }
        }
        System.out.println(result);
    }
}
