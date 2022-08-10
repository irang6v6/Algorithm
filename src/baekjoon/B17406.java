package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17406 {

	static int[][] order;
	static int[][] data;
	static int[][] original;
	static char[] dir = { '하', '우', '상', '좌' };
	static int[] dx = { 1, 0, -1, 0 };// 하,우,상,좌
	static int[] dy = { 0, 1, 0, -1 };// 하,우,상,좌
	static int min = Integer.MAX_VALUE;

	public static void perm(int[] input, int[] output, boolean[] visited, int depth, int n, int K, int[][] data,
			int[][] order, int[][] original) {
		if (depth == K) {
			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < data[0].length; j++) {
					data[i][j] = original[i][j];
				}
			}

			for (int i = 0; i < output.length; i++) {
				int r = order[output[i]][0] - 1; // A는 [1,1]에서부터 시작하기 때문에 [0,0]에서 시작하는 배열에 맞춤
				int c = order[output[i]][1] - 1;
				int s = order[output[i]][2];// 회전해야 할 그룹 갯수

				////////// TO DO //////////////
				for (int j = 1; j <= s; j++) {
					int x = r - j;
					int y = c - j;
					int temp = data[x][y];// 스와핑을 위해 현재 데이터 값을 보관
					int idx = 0;// 방향
					while (idx < 4) {// 하우상좌 순서로 처리
						int nx = x + dx[idx];
						int ny = y + dy[idx];
						if (nx < r - j || nx > r + j || ny < c - j || ny > c + j) {// 범위를 벗어나면 방향 전환하여 조건에 맞을때까지 탐색
							idx++;

						} else {
							data[x][y] = data[nx][ny];
							x = nx;
							y = ny;
						}
					} // while을 나갈 때는 스타트 지점의 값만 빼고 모든 값이 한칸씩 전진된 상태
					data[r - j][c - j + 1] = temp;
				}

			} // end i
			int sum = 0;
			for (int i1 = 0; i1 < data.length; i1++) {
				sum = 0;
				for (int j = 0; j < data[0].length; j++) {
					sum += data[i1][j];
				}
				if (sum < min) {
					min = sum;
				}
			}
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visited[i] != true) {
				visited[i] = true;
				output[depth] = input[i];
				perm(input, output, visited, depth + 1, n, K, data, order, original);
				output[depth] = 0; // 이 줄은 없어도 됨
				visited[i] = false;
			}
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int K = Integer.parseInt(str[2]);

		int[][] data = new int[N][M];
		int[][] original = new int[N][M];

		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				data[i][j] = Integer.parseInt(str[j]);
				original[i][j] = Integer.parseInt(str[j]);
			}
		}

		int[][] order = new int[K][3];
		for (int i = 0; i < K; i++) {
			str = br.readLine().split(" ");
			order[i][0] = Integer.parseInt(str[0]); // r
			order[i][1] = Integer.parseInt(str[1]); // c
			order[i][2] = Integer.parseInt(str[2]); // s
		}
		// ------------------입력---------------------

		int[] input = new int[K];
		int[] output = new int[K];
		boolean[] visited = new boolean[K];
		for (int i = 0; i < K; i++) {
			input[i] = i;
		}
		perm(input, output, visited, 0, K, K, data, order, original);

		System.out.println(min);
	}
}
