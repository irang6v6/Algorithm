import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int C;
	static Node[] adjList;
	static boolean[] visited;

	static class Node {
		int to;
		Node next;

		public Node(int to, Node next) {
			this.to = to;
			this.next = next;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		C = Integer.parseInt(br.readLine());
		int V = Integer.parseInt(br.readLine());

		adjList = new Node[C+1];
		visited = new boolean[C+1];

		for (int v = 0; v < V; v++) {
			String[] input = br.readLine().split(" ");
			int from = Integer.parseInt(input[0]);
			int to = Integer.parseInt(input[1]);
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}

		bfs();

		int answer = 0;
		for (int i = 0; i < visited.length; i++) {
			if (visited[i])
				answer++;
		}
		System.out.println(answer-1);
	}

	private static void bfs() {
		Queue<Integer> queue = new ArrayDeque<>();
		visited[1] = true;
		queue.offer(1);

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
				if (!visited[temp.to]) {
					visited[temp.to] = true;
					queue.offer(temp.to);
				}
			}
		}

	}
}
