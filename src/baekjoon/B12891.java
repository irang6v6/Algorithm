package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

//https://www.acmicpc.net/problem/12891
public class B12891 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int totalLength = Integer.parseInt(input[0]);
		int partLength = Integer.parseInt(input[1]);
		String s = br.readLine();
		input = br.readLine().split(" ");
		int[] DNA = new int[4];
		for (int i = 0; i < 4; i++) {
			DNA[i] = Integer.parseInt(input[i]);
		}
		int result = 0;
		int[] count = new int[4];

		Map<Character, Integer> map = new HashMap<>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);

		for (int i = 0; i < partLength; i++) {
			count[map.get(s.charAt(i))]++;
		}

		for (int k = 0; k < 4; k++) {
			if (count[k] < DNA[k])
				break;
			if (k == 3)
				result++;
		}

		for (int i = 1; i < totalLength - partLength + 1; i++) {
			count[map.get(s.charAt(i - 1))]--;
			count[map.get(s.charAt(i + partLength - 1))]++;

			for (int k = 0; k < 4; k++) {
				if (count[k] < DNA[k])
					break;
				if (k == 3) {
					result++;
				}
			}
		}
		System.out.println(result);
	}

}
