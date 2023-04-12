package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/11659
public class B11659 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 5 3
		int size = Integer.parseInt(st.nextToken());
		int[] nums = new int[size]; // size크기의 배열 초기화
		int tc = Integer.parseInt(st.nextToken()); // 테스트케이스

		st = new StringTokenizer(br.readLine(), " "); // 줄 째로 읽어서
		for (int i = 0; i < nums.length; i++) { // nums에 숫자 하나씩
			nums[i] = Integer.parseInt(st.nextToken());
			if (i > 0) {
				nums[i] += nums[i - 1]; // 누적합 5,9,12,14,15
			}
		}

		for (int i = 0; i < tc; i++) { // 테스트 케이스마다
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken()) - 1; // 구간 시작 인덱스
			int end = Integer.parseInt(st.nextToken()) - 1; // 구간 끝 인덱스
			int result = 0;

			if (start == 0) {
				result = nums[end]; // 1~n 까지의 합이면 nums[n-1]출력
			} else {
				result = nums[end] - nums[start - 1]; // m~n까지의 합이면 nums[n-1]-nums[m-1]
			}
			sb.append(result).append("\n"); // sb.append로 한번에 출력
		}
		System.out.println(sb);
	}
}