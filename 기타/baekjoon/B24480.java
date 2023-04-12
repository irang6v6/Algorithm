package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B24480 {

	// 무방향 그래프, 양방향 간선
	static ArrayList<Integer>[] adjList;
	static int[] visited;
	static int R, order = 1;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		R = Integer.parseInt(input[2]) - 1;

		adjList = new ArrayList[N];
		visited = new int[N];

		for (int i = 0; i < N; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int from = Integer.parseInt(input[0]) - 1;
			int to = Integer.parseInt(input[1]) - 1;
			adjList[from].add(to);
			adjList[to].add(from);
		}

		for (int i = 0; i < N; i++) {
			Collections.sort(adjList[i], Collections.reverseOrder());
		}

//			System.out.println(Arrays.deepToString(temp));

//			for(Node tp=adjList[R];tp!=null;tp=tp.next) {
//				System.out.println(tp.to);
//			}
//			System.out.println("------------");

		dfs(R);

		for (int i : visited) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int cur) {

		if (visited[cur] > 0) {
			return;
		}
		visited[cur] = order++;
		for (int x : adjList[cur]) {
			dfs(x);
//					break;
		}

	}
}
