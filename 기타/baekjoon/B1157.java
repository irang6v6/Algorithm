package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1157 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] c = new int[26];
		s = s.toUpperCase();
		for (int i = 0; i < s.length(); i++) {
			c[s.charAt(i) - 65] += 1;
		}
		int max = 0;
		for (int i = 0; i < c.length; i++) {
			if (c[i] > max) {
				max = c[i];
			}
		}

		int count = 0;
		char result = ' ';
		for (int i = 0; i < c.length; i++) {
			if (c[i] == max) {
				count++;
				result = (char) (i + 65);
			}
		}

		if (count == 1) {
			System.out.println(result);
		} else {
			System.out.println("?");
		}

	}
}
