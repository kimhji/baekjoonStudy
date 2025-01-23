import java.util.Scanner;

public class Main {
    static long n; 
    static long ans = 0; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextLong();

        for (int len = 1; len <= String.valueOf(n).length(); len++) {
            generatePalindrome(0, new char[len]);
        }

        System.out.println(ans);
    }

    public static void generatePalindrome(int idx, char[] res) {
        int len = res.length;

        if (idx >= (len + 1) / 2) {
            long palindrome = Long.parseLong(new String(res));
            if (palindrome <= n) { 
                ans++;
            }
            return;
        }

        for (int i = (idx == 0 ? 1 : 0); i <= 9; i++) {
            res[idx] = res[len - idx - 1] = (char) (i + '0');
            generatePalindrome(idx + 1, res); 
        }
    }
}
