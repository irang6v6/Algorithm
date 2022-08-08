package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] in = br.readLine().split(" ");
		int n = Integer.parseInt(in[0]);
		int k = Integer.parseInt(in[1]); // 입력

		Queue<Integer> queue = new LinkedList<>();// 큐 사용

		for (int i = 1; i <= n; i++) { // 큐에 1~n까지의 값을 삽입
			queue.add(i);
		}

		int idx = 1;
		sb.append("<");
		while (queue.size() > 0) {
			if (idx < k) { // 3번째가 아니면 deque-enque해서 맨 뒤로 보냄
				queue.add(queue.poll());
				idx++;
			} else { // 3번째면 값 삭제하고 sb에 추가
				sb.append(queue.poll()).append(", ");
				idx = 1;
			}
		}
		String str = sb.substring(0, sb.length() - 2); // 뒤에 , 떼줌
		str += ">";
		System.out.println(str);
	}
}
