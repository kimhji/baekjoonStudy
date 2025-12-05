import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> dictionary = new HashMap<>();
        String tree;
        int total = 0;

        while ((tree = br.readLine()) != null) {
            tree = tree.trim();
            dictionary.put(tree, dictionary.getOrDefault(tree, 0) + 1);
            total++;
        }

        List<String> trees = new ArrayList<>(dictionary.keySet());
        Collections.sort(trees);

        for (String treeStr : trees) {
            double percentage = dictionary.get(treeStr) * 100.0 / total;
            System.out.printf("%s %.4f\n", treeStr, percentage);
        }
    }
}
