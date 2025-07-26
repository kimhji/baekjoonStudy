import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int count = 0;
        Set<String> seen = new HashSet<>();

        while (true) {
            int[] b = new int[n];

            for (int i = 0; i < n; i++) {
                int cnt = 0;
                for (int j = i + 1; j < n; j++) {
                    if (a[j] > a[i]) cnt++;
                }
                b[i] = cnt;
            }

            count++;

            // check if a == b
            boolean same = true;
            for (int i = 0; i < n; i++) {
                if (a[i] != b[i]) {
                    same = false;
                    break;
                }
            }

            if (same) {
                System.out.println(count);
                return;
            }

            // check cycle
            String key = Arrays.toString(b);
            if (seen.contains(key)) {
                System.out.println(-1);
                return;
            }
            seen.add(key);

            // update a
            a = b;
        }
    }
}
