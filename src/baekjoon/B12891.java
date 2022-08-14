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
		} // --------입력--------
		int result = 0;
		int[] count = new int[4];

		Map<Character, Integer> map = new HashMap<>(); // 각 char마다 고유 idx값을 map에 저장
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);

		for (int i = 0; i < partLength; i++) { // 'A'를 만나면 count[0]++;
			count[map.get(s.charAt(i))]++; // 맨 앞~ 부분문자열 길이만큼 자른다.
		}

		for (int k = 0; k < 4; k++) { // 맨 앞~부분문자열에서 조건이 맞는 결과값이 나왔다면 ++;
			if (count[k] < DNA[k])
				break;
			if (k == 3)
				result++;
		}

		for (int i = 1; i < totalLength - partLength + 1; i++) { // 뒤로 한 칸 넘어가서 다음 부분문자열을 확인하는데
			count[map.get(s.charAt(i - 1))]--; // 아까 맨앞~n칸 값 구해놓은 것에서 맨앞 빼고
			count[map.get(s.charAt(i + partLength - 1))]++;// n+1칸 값 더해줌. 맨앞+1~n칸의 값은 그대로 갖다 사용하게 되어 연산시간 down

			for (int k = 0; k < 4; k++) {// 결과에 맞는 값인지 확인
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
