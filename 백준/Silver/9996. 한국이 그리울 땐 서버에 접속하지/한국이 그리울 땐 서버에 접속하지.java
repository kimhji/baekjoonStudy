
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String[] bothWords = br.readLine().trim().split("\\*");

        for (int i = 0; i < N; i++) {
            String line = br.readLine().trim();

            if (isValid(bothWords, line)) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }

    public static boolean isValid(String[] pattern, String str) {
        if (!str.startsWith(pattern[0])) {
            return false;
        }
        if (!str.endsWith(pattern[1])) {
            return false;
        }
        if (pattern[0].length() + pattern[1].length() > str.length()) {
            return false;
        }

        return true;
    }
}
