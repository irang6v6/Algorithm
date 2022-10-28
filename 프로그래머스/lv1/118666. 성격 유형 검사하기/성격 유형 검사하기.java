import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static String solution(String[] survey, int[] choices) {
		String[][] types = { { "R", "T" }, { "C", "F" }, { "J", "M" }, { "A", "N" } };

		// Map<성격유형, 점수>
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < choices.length; i++) {
			if (choices[i] == 4)
				continue;
			String[] type = survey[i].split("");
			if (choices[i] < 4) {
				map.put(type[0], map.getOrDefault(type[0], 0) + (4 - choices[i]));
			} else {
				map.put(type[1], map.getOrDefault(type[1], 0) + (choices[i] - 4));
			}
		}

		StringBuilder answer = new StringBuilder();
		for (int i = 0; i < types.length; i++) {
			if(map.getOrDefault(types[i][0], 0)>= map.getOrDefault(types[i][1],0)) {
				answer.append(types[i][0]);
			}else {
				answer.append(types[i][1]);
			}
			
		}

		return answer.toString();
	}

	
}
