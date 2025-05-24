import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();

        for (int i = 0; i < 5; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < 4 * len + 1; j++) {
                if (i == 0 || i == 4) {
                    if (j % 4 == 2) {
                        if (((j - 2) / 4) % 3 == 2) {
                            line.append('*');
                        } else {
                            line.append('#');
                        }
                    } else {
                        line.append('.');
                    }
                } else if (i == 1 || i == 3) {
                    if (j % 2 == 1) {
                        if (j % 12 == 9 || j % 12 == 11) {
                            line.append('*');
                        } else {
                            line.append('#');
                        }
                    } else {
                        line.append('.');
                    }
                } else { // i == 2 (middle line)
                    if (j % 2 == 0) {
                        if (j % 4 == 2) {
                            line.append(s.charAt(j / 4));
                        } else {
                            if (j == 0 || (len % 3 != 0 && j == 4 * len)) {
                                line.append('#');
                            } else {
                                if (j % 12 == 0 || j % 12 == 8) {
                                    line.append('*');
                                } else {
                                    line.append('#');
                                }
                            }
                        }
                    } else {
                        line.append('.');
                    }
                }
            }
            System.out.println(line);
        }

        sc.close();
    }
}
