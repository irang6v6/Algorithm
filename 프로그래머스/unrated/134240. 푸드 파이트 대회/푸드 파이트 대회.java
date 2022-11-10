class Solution {
	public static String solution(int[] food) {
		StringBuilder p1 = new StringBuilder();
		for (int i = 1; i < food.length; i++) {
			for (int j = 0; j < food[i] / 2; j++) {
				p1.append(i);
			}
		}

		StringBuilder answer = new StringBuilder();
		answer.append(p1).append("0").append(p1.reverse());
		return answer.toString();
	}

	
}