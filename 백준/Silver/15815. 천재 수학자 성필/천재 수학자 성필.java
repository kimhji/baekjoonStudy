
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inputs = br.readLine().trim().toCharArray();
        Stack<Integer> stack = new Stack<Integer>();

        for (char ch : inputs) {
            if (ch >= '0' && ch <= '9') {
                stack.add(ch - '0');
                continue;
            }
            Integer data_2 = stack.pop();
            Integer data_1 = stack.pop();
            int newNumber = 0;
            switch (ch) {
                case '+':
                    newNumber = data_2 + data_1;
                    break;
                case '-':
                    newNumber = data_1 - data_2;
                    break;
                case '*':
                    newNumber = data_1 * data_2;
                    break;
                case '/':
                    newNumber = data_1 / data_2;
                    break;
            }
            stack.add(newNumber);
        }
        System.out.println(stack.pop());
    }
}
