import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static final int INF = 9999999;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < TC; tc++) {
			int n = Integer.parseInt(br.readLine()); // 편의점 수
			int[][] loc = new int[n + 2][2];

			for (int i = 0; i < n + 2; i++) {
				String[] input = br.readLine().split(" ");
				loc[i][0] = Integer.parseInt(input[0]);
				loc[i][1] = Integer.parseInt(input[1]);
			}

			int[][] distance = new int[n + 2][n + 2];
			for (int i = 0; i < n + 2; i++) {
				for (int j = 0; j < n + 2; j++) {
					if (i == j) {
						distance[i][j] = 0;
					} else {
						int d = Math.abs(loc[i][0] - loc[j][0]) + Math.abs(loc[i][1] - loc[j][1]);
						if (d > 1000) {
							distance[i][j] = INF;
							distance[j][i] = INF;
						} else {
							distance[i][j] = d;
							distance[j][i] = d;
						}
					}
				}
			}
			int N = n + 2;
			for (int k = 0; k < N; k++) {
				for (int i = 0; i < N; i++) {
					if (i == k)
						continue;
					for (int j = 0; j < N; j++) {
						if (i == j || j == k)
							continue;
						if (distance[i][k]<=1000 && distance[k][j]<=1000) {
							distance[i][j] = 1000;
						}

					}
				}
			}
			
			if(distance[0][n+1]<INF) {
				sb.append("happy");
			}else {
				sb.append("sad");
			}
			sb.append("\n");

//			for (int i = 0; i < n + 2; i++) {
//				for (int j = 0; j < n + 2; j++) {
//					System.out.print(distance[i][j] + " ");
//				}
//				System.out.println();
//			}
		}
		System.out.println(sb);
	}
}
