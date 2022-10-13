import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N, M;
	static int[][] list;
	static boolean[] visited;

	private static void dfs(int start) {
		if (visited[start] = true) {
			System.out.print(start + " ");
		}
		for (int i = 0; i < M * 2; i++) {
			if (list[i][0] == start) {
				if (!visited[list[i][1]]) {
					dfs(list[i][1]);
				}
			}
		}
	}

	private static void bfs(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(start);
		visited[start] = true;
		while (!q.isEmpty()) {
			int t = q.poll();
			System.out.print(t + " ");
			for (int i = 0; i < M * 2; i++) {
				if (list[i][0] == t) {
					if (!visited[list[i][1]]) {
						q.offer(list[i][1]);
						visited[list[i][1]] = true;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		int V = sc.nextInt();

		list = new int[M * 2][2];
		for (int i = 0; i < M * 2; i += 2) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			list[i][0] = from;
			list[i][1] = to;
			list[i + 1][0] = to;
			list[i + 1][1] = from;
		}

		Arrays.sort(list, (int[] e1, int[] e2) -> e1[1] - e2[1]);
		visited = new boolean[N + 1];
		dfs(V);
		System.out.println();
		visited = new boolean[N + 1];
		bfs(V);

	}
}
