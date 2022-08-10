package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11382 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		Long A = Long.parseLong(s[0]);
		Long B = Long.parseLong(s[1]);
		Long C = Long.parseLong(s[2]);
		StringBuilder sb = new StringBuilder();
		sb.append(A + B + C);
		System.out.println(sb);
	}
}
