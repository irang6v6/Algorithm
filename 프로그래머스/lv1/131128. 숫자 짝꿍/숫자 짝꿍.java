public class Solution {
	public static String solution(String X, String Y) {
		int[] numbersX = new int[10];
		int[] numbersY = new int[10];

		for (int i = 0; i < X.length(); i++) {
			int idx = X.charAt(i) - 48;
			numbersX[idx]++;
		}
		for (int i = 0; i < Y.length(); i++) {
			int idx = Y.charAt(i) - 48;
			numbersY[idx]++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 9; i >= 0; i--) {
			while (numbersX[i] >= 1 && numbersY[i] >= 1) {
				numbersX[i]--;
				numbersY[i]--;
				sb.append(i);
			}
		}
		String answer = sb.toString();
		if (answer.equals("")) {
			return "-1";
		} else if (answer.startsWith("0")) {
			return "0";
		} else {
			return answer;
		}
	}

	
}