package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1010 {
	static int[][] dy;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			String[] s = br.readLine().split(" ");
			int N = Integer.parseInt(s[0]);
			int M = Integer.parseInt(s[1]);
			int[][] dy = new int[M + 1][N + 1]; // 값을 저장해서 중복 호출을 막는다
			bw.write(combination(M, N, dy) + "\n"); // 조합으로 M개 중에 N개 고르는 경우의 수를 계산
		}
		bw.close();
	}

	static int combination(int m, int n, int[][] dy) {
		if (dy[m][n] > 0) {
			return dy[m][n]; // 이전에 계산했다면 값을 바로 전달
		}
		if (m == n || n == 0) { // 끝까지 골랐다면
			return 1;
		} else {
			return dy[m][n] = combination(m - 1, n - 1, dy) + combination(m - 1, n, dy); // 뽑는 경우+안뽑는 경우
		}
	}
}
