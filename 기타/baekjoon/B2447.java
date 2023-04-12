package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2447 {
	static int N;
	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
//		N = 2187;
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(map[i], '*');
		}

		star(N);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void star(int n) {
		if (n == 1)
			return;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int next = n / 3;
				if (i % n >= (n / 3) && i % n < (n / 3) * 2 && j % n >= (n / 3) && j % n < (n / 3) * 2) {
					map[i][j] = ' ';
				}
			}
		}
		star(n / 3);
	}
}
