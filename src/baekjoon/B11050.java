package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11050 {
	static int N, K, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);

		combination(0, 0);
		System.out.println(result);
	}

	private static void combination(int depth, int start) {
		if (depth == K) {
			result++;
			return;
		}

		for (int i = start; i < N; i++) {
			combination(depth + 1, i + 1);
		}
	}

}
