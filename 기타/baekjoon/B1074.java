package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1074 {
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]); // 2^n X 2^n의 배열
		int r = Integer.parseInt(s[1]);
		int c = Integer.parseInt(s[2]);

		int p = (int) Math.pow(2, N); //한 면의 길이
		// -----------입력------------

		recur(r, c, p);

		System.out.println(count);
	}

	private static void recur(int r, int c, int p) {
		if (p == 1) { // 기저조건
			return;
		}

		if (r < p / 2) {
			if (c < p / 2) {
				recur(r, c, p / 2);
			} else {
				count += ((p / 2) * (p / 2) * 1);
				recur(r, (c - p / 2), p / 2); //r이랑 c를 p의 크기에 맞춰 줄여준다
			}
		} else {
			if (c < p / 2) {
				count += ((p / 2) * (p / 2) * 2);
				recur((r - p / 2), c, p / 2);
			} else {
				count += ((p / 2) * (p / 2) * 3);
				recur(r - p / 2, c - p / 2, p / 2);
			}
		}

	}
}
