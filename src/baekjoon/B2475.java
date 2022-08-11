package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2475 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int sum = Integer.parseInt(s[0]) * Integer.parseInt(s[0]) + Integer.parseInt(s[1]) * Integer.parseInt(s[1])
				+ Integer.parseInt(s[2]) * Integer.parseInt(s[2]) + Integer.parseInt(s[3]) * Integer.parseInt(s[3])
				+ Integer.parseInt(s[4]) * Integer.parseInt(s[4]);
		if (sum == 0) {
			System.out.println(0);
		} else {
			System.out.println(sum % 10);
		}
	}

}
