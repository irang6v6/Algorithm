import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] C = new int[N];
			String[] st = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st[i]);
			}

			int size = 0;
			for (int i = 0; i < N; i++) { // 앞쪽부터 모든 원소를 기준으로 자신을 끝으로 하는 C 계산
				int pos = Arrays.binarySearch(C, 0, size, arr[i]);
				if (pos >= 0)
					continue;

				int insertPos = Math.abs(pos) - 1; // 맨 뒤, 기존원소 대체자리
				C[insertPos] = arr[i];

				if (insertPos == size)
					size++;
			}
			sb.append("#" + tc + " " + size).append("\n");
		}
		System.out.println(sb);
	}
}