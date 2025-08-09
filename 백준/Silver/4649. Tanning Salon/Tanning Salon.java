import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line.equals("0")) break;

            String[] parts = line.trim().split(" ");
            int num = Integer.parseInt(parts[0]); 

            if (parts.length == 1) continue; 

            String customers = parts[1];
            Set<Character> tanningSet = new HashSet<>();
            int cnt = 0;

            for (char c : customers.toCharArray()) {
                if (!tanningSet.contains(c) && tanningSet.size() < num) {
                    tanningSet.add(c);
                } else if (tanningSet.contains(c)) {
                    tanningSet.remove(c); 
                } else if (!tanningSet.contains(c) && tanningSet.size() >= num) {
                    cnt++; 
                }
            }

            if (cnt == 0) {
                System.out.println("All customers tanned successfully.");
            } else {
                System.out.println((cnt / 2) + " customer(s) walked away.");
            }
        }
    }
}
