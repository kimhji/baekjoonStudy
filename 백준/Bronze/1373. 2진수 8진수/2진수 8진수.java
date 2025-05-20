import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.nextLine();

        int len = binary.length();
        int padding = (3 - (len % 3)) % 3;
        StringBuilder paddedBinary = new StringBuilder();

        for (int i = 0; i < padding; i++) {
            paddedBinary.append("0");
        }
        paddedBinary.append(binary);

        StringBuilder octal = new StringBuilder();
        for (int i = 0; i < paddedBinary.length(); i += 3) {
            String group = paddedBinary.substring(i, i + 3);
            int decimal = Integer.parseInt(group, 2);
            octal.append(decimal);
        }

        System.out.println(octal.toString());
    }
}
