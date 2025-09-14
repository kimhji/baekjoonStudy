import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄 읽기 (빈 줄 무시)
        String firstLine;
        do {
            firstLine = br.readLine();
            if (firstLine == null) return;
        } while (firstLine.trim().isEmpty());

        String[] parts = firstLine.trim().split("\\s+");
        int N = Integer.parseInt(parts[0]);
        int M = Integer.parseInt(parts[1]);

        boolean[][] data = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line;
            do {
                line = br.readLine();
                if (line == null) line = "";
            } while (line.trim().isEmpty());
            line = line.replaceAll("\\s+", ""); // 혹시 공백 섞여있으면 제거

            // 안전히 길이 맞추기 (입력 오류 대비)
            if (line.length() < M) {
                line = String.format("%-" + M + "s", line).replace(' ', '0');
            }

            for (int j = 0; j < M; j++) {
                data[i][j] = (line.charAt(j) == '1'); // 1 -> true
            }
        }

        int count = 0;
        // 오른쪽 아래부터 검사
        for (int i = N - 1; i >= 0; i--) {
            for (int j = M - 1; j >= 0; j--) {
                if (data[i][j]) { // 1이면 뒤집기
                    count++;
                    for (int ii = 0; ii <= i; ii++) {
                        for (int jj = 0; jj <= j; jj++) {
                            data[ii][jj] = !data[ii][jj];
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}
