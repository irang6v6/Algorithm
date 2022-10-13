import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class Main {

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
			Collections.sort(adjList[i]);
		}

//			System.out.println(Arrays.deepToString(temp));

//			for(Node tp=adjList[R];tp!=null;tp=tp.next) {
//				System.out.println(tp.to);
//			}
//			System.out.println("------------");

		visited[R] = order++;
		bfs(R);

		for (int i : visited) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int cur) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(cur);

		while (!queue.isEmpty()) {
			cur = queue.poll();
			for (int i = 0; i < adjList[cur].size(); i++) {
				if (visited[adjList[cur].get(i)] == 0) {
					visited[adjList[cur].get(i)] = order++;
					queue.offer(adjList[cur].get(i));
				}
			}
		}

	}
}
