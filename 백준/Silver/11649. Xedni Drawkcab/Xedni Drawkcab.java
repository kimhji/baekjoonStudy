
import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        List<String> strs = new LinkedList<String>();
        for (int i = 0; i < N; i++) {
            char[] chs = br.readLine().trim().toCharArray();
            String tns = "";
            for (int j = chs.length - 1; j >= 0; j--) {
                tns += chs[j];
            }
            strs.add(tns);
        }
        Collections.sort(strs);
        for (String str : strs) {
            System.out.println(str);
        }
    }
}
