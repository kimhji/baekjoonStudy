import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] line = br.readLine().trim().split(" ");
		int N = Integer.parseInt(line[0]);
		int M = Integer.parseInt(line[1]);

		int[] A = new int[N];
		int[] B = new int[M];

		line = br.readLine().trim().split(" ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(line[i]);
		}

		line = br.readLine().trim().split(" ");
		for (int i = 0; i < M; i++) {
			B[i] = Integer.parseInt(line[i]);
		}

		int i = 0, j = 0;
		while (i < N && j < M) {
			if (A[i] <= B[j]) {
				sb.append(A[i++]).append(' ');
			} else {
				sb.append(B[j++]).append(' ');
			}
		}

		while (i < N) sb.append(A[i++]).append(' ');
		while (j < M) sb.append(B[j++]).append(' ');

		System.out.println(sb.toString().trim());
	}
}
