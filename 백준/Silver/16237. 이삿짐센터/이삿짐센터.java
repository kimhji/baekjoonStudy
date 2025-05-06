import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int D = scanner.nextInt();
        int E = scanner.nextInt();
        
        int count = E + D;
        A -= D;

        // First loop: handling C
        while (C > 0) {
            count++;
            if (B > 0) {
                B--;
                C--;
            } else if (A > 0) {
                A -= 2;
                C--;
            } else {
                C--;
            }
        }

        while (B > 0) {
            count++;
            if (B > 1 && A > 0) {
                B -= 2;
                A--;
            } else if (B > 0 && A > 0) {
                B--;
                A -= 3;
            } else {
                B -= 2;
            }
        }

        while (A > 0) {
            count++;
            A -= 5;
        }

        System.out.println(count);
        
        scanner.close();
    }
}
