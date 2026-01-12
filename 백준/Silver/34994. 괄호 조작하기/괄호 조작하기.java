import java.io.*;
import java.util.*;

public class Main {

    static final char[] BRACKETS = {'(', ')', '[', ']', '{', '}'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine().trim());

        while (N-- > 0) {
            String s = br.readLine().trim();
            int len = s.length();

            // 홀수 길이는 절대 불가능
            if (len % 2 == 1) {
                sb.append("NO\n");
                continue;
            }

            // 0번 변경
            if (isValid(s)) {
                sb.append("YES 0\n");
                continue;
            }

            boolean ok = false;
            char[] arr = s.toCharArray();

            // 1번 변경 시도
            for (int i = 0; i < len && !ok; i++) {
                char original = arr[i];
                for (char c : BRACKETS) {
                    if (c == original) continue;
                    arr[i] = c;

                    if (isValid(arr)) {
                        sb.append("YES 1\n");
                        sb.append(i + 1).append(" ").append(c).append("\n");
                        ok = true;
                        break;
                    }
                }
                arr[i] = original; // 복구
            }

            if (!ok) sb.append("NO\n");
        }

        System.out.print(sb.toString());
    }

    // 괄호 유효성 검사
    static boolean isValid(String s) {
        return isValid(s.toCharArray());
    }

    static boolean isValid(char[] s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char open = stack.pop();
                if (!match(open, c)) return false;
            }
        }
        return stack.isEmpty();
    }

    static boolean match(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }
}
