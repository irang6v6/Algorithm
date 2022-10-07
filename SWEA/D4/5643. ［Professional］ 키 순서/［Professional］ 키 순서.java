import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] students = new int[N + 1][N + 1];
			int M = Integer.parseInt(br.readLine());
			for (int i = 0; i < M; i++) {
				String[] input = br.readLine().split(" ");
				students[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = 1;
			}

			for (int k = 1; k < N + 1; k++) {
				for (int i = 1; i < N + 1; i++) {
					if (i == k)
						continue;// 출발지와 경유지가 같다면 다음 출발지
					for (int j = 1; j < N + 1; j++) {
						if (i == j || j == k)
							continue;// 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
						if (students[i][k] == 1 && students[k][j] == 1) { // 갈 수 있는 거리면
							students[i][j] = 1; // 갈 수 있다고 저장
						}
					}
				}
			}

			int answer = 0;
			for (int i = 1; i < students.length; i++) {
				int count = 0;
				for (int j = 1; j < students.length; j++) {
					count += students[i][j];
					count += students[j][i];
				}
				if (count == N - 1) {
					answer++;
				}
			}

			sb.append("#" + tc + " " + answer).append("\n");

		}
		System.out.println(sb);
	}
}
