import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        List<String> nums = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            StringBuilder sb = new StringBuilder();
            for (char ch : line.toCharArray()) {
                if (Character.isDigit(ch)) {
                    sb.append(ch);
                } else {
                    if (sb.length() > 0) {
                        nums.add(removeLeadingZeros(sb.toString()));
                        sb.setLength(0);
                    }
                }
            }
            if (sb.length() > 0) {
                nums.add(removeLeadingZeros(sb.toString()));
            }
        }

        nums.sort((a, b) -> {
            if (a.length() != b.length())
                return a.length() - b.length();
            return a.compareTo(b);
        });

        for (String num : nums) {
            System.out.println(num);
        }
    }

    private static String removeLeadingZeros(String num) {
        int idx = 0;
        while (idx < num.length() - 1 && num.charAt(idx) == '0') {
            idx++;
        }
        return num.substring(idx);
    }
}
