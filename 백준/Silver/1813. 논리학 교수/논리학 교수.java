import java.io.*;
import java.util.*;

class Main {
    public static int solution(String blackBoard) {
        String[] lines = blackBoard.split("\n");
        int N = Integer.parseInt(lines[0].trim());

        if (N < 1 || N > 50) {
            return -1;
        }

        String[] numStrings = lines[1].trim().split(" ");
        if (numStrings.length != N) {
            return -1;
        }

        int[] contents = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(numStrings[i]);
            if (num < 0 || num > 50) {
                return -1;
            }
            contents[i] = num;
        }

        // 내림차순 정렬
        java.util.Arrays.sort(contents);
        reverse(contents);

        for (int i = 0; i < N; i++) {
            int content = contents[i];
            int count = 0;

            for (int j = 0; j < N; j++) {
                if (contents[j] == content) {
                    count++;
                }
            }

            if (content == count) {
                return content;
            }
        }

        // 내용 중에 0이 포함되어 있지 않으면 0 반환
        boolean hasZero = false;
        for (int value : contents) {
            if (value == 0) {
                hasZero = true;
                break;
            }
        }

        return hasZero ? -1 : 0;
    }

    // 배열을 역순으로 뒤집는 함수
    private static void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine().trim()+"\n"+br.readLine().trim();
        System.out.println(solution(data));
    }
}
