package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1152 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		s = s.trim();
		String[] str = s.split(" ");
		if (s == "") {
			System.out.println(0);
		} else
			System.out.println(str.length);
	}
}
