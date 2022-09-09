package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B25501 {
	static StringBuilder sb;

	public static int recursion(String s, int l, int r, int cnt) {
		if (l >= r) {
			sb.append(1 + " " + cnt).append("\n");
			return 1;
		} else if (s.charAt(l) != s.charAt(r)) {
			sb.append(0 + " " + cnt).append("\n");
			return 0;
		} else
			return recursion(s, l + 1, r - 1, cnt + 1);
	}

	public static int isPalindrome(String s, int cnt) {
		return recursion(s, 0, s.length() - 1, cnt);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String s = br.readLine();
			isPalindrome(s, 1);
		}
		System.out.println(sb);
	}

}
