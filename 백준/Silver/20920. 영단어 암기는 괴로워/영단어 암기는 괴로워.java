import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> wordCount = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < M) continue;
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        List<String> words = new ArrayList<>(wordCount.keySet());

        words.sort((a, b) -> {
            int freqCompare = wordCount.get(b) - wordCount.get(a);
            if (freqCompare != 0) return freqCompare;

            int lengthCompare = b.length() - a.length();
            if (lengthCompare != 0) return lengthCompare;

            return a.compareTo(b);
        });

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word).append("\n");
        }
        System.out.print(sb);
    }
}
