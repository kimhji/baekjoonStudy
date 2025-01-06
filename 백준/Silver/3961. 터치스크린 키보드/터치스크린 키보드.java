import java.io.*;
import java.util.*;

public class Main {
    static Map<String, int[]> keyBoard = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        initKeyBoard();
        int T = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < T; i++) {
            String[] line = br.readLine().trim().split(" ");
            String origin = line[0];
            int N = Integer.parseInt(line[1]);
            String[] StringCase = new String[N];
            Map<String, Integer> data = new HashMap<>();

            for (int j = 0; j < N; j++) {
                StringCase[j] = br.readLine().trim();
                int count = countDifference(origin, StringCase[j]);
                data.put(StringCase[j], count);
            }

            Arrays.sort(StringCase, (s1, s2) -> {
                int diff = data.get(s1) - data.get(s2);
                return (diff != 0) ? diff : s1.compareTo(s2);
            });

            for (String s : StringCase) {
                System.out.println(s + " " + data.get(s));
            }
        }
    }

    public static void initKeyBoard() {
        String[] keys = { "qwertyuiop", "asdfghjkl", "zxcvbnm" };
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < keys[i].length(); j++) {
                keyBoard.put(keys[i].substring(j, j + 1), new int[] { i, j });
            }
        }
    }

    public static int countDifference(String origin, String compare) {
        int count = 0;
        int N = origin.length();

        for (int i = 0; i < N; i++) {
            String one = origin.substring(i, i + 1).toLowerCase();
            String two = compare.substring(i, i + 1).toLowerCase();
            int[] oneLoc = keyBoard.get(one);
            int[] twoLoc = keyBoard.get(two);
            count += Math.abs(oneLoc[0] - twoLoc[0]);
            count += Math.abs(oneLoc[1] - twoLoc[1]);
        }
        return count;
    }
}
