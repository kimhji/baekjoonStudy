
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        boolean[] existKey = new boolean[26];
        for (int i = 0; i < N; i++) {
            String[] words = br.readLine().trim().split(" ");
            String result = "";
            boolean setComplete = false;
            for (String word : words) {
                if (setComplete) {
                    result += word + " ";
                    continue;
                }
                char firstChar = word.charAt(0);
                if (firstChar >= 'a' && firstChar <= 'z') {
                    if (!existKey[firstChar - 'a']) {
                        result += "[" + firstChar + ']' + word.substring(1) + " ";
                        existKey[firstChar - 'a'] = true;
                        setComplete = true;
                        continue;
                    }
                } else if (firstChar >= 'A' && firstChar <= 'Z') {
                    if (!existKey[firstChar - 'A']) {
                        result += "[" + firstChar + ']' + word.substring(1) + " ";
                        existKey[firstChar - 'A'] = true;
                        setComplete = true;
                        continue;
                    }
                }
                result += word + " ";
            }

            if (!setComplete) {
                char[] chars = result.toCharArray();
                result = "";
                for (char ch : chars) {
                    if (setComplete) {
                        result += ch;
                        continue;
                    }
                    if (ch >= 'a' && ch <= 'z') {
                        if (!existKey[ch - 'a']) {
                            existKey[ch - 'a'] = true;
                            setComplete = true;
                            result += "[" + ch + ']';
                            continue;
                        }
                    } else if (ch >= 'A' && ch <= 'Z') {
                        if (!existKey[ch - 'A']) {
                            existKey[ch - 'A'] = true;
                            setComplete = true;
                            result += "[" + ch + ']';
                            continue;
                        }
                    }
                    result += ch;
                }
            }

            System.out.println(result);
        }
    }
}
