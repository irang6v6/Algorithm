package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2563
public class B2563 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] T = new int[Integer.parseInt(br.readLine())][2];
		boolean[][] white = new boolean[100][100]; // 바탕지
		int duplicate = 0;

		for (int i = 0; i < T.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken()); // 검은종이 좌표 받아서

			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) { // 흰종이에 표시
					if (white[j][k] == true) { // 이미 표시되어 있다면 중복값 추가
						duplicate++;
					} else
						white[j][k] = true; // 안겹치는 부분이면 표시
				}
			}
		} // -------------입력

		System.out.println((T.length * 100) - duplicate); // 검은종이 개당 넓이 - 겹치는 넓이
	}
}
