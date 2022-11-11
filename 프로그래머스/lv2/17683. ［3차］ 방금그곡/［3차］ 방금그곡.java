class Solution {
	public static String solution(String m, String[] musicinfos) {
		int maxTime = Integer.MIN_VALUE;
		String answer = "(None)";

		// # 처리
		String[] hash = { "C#", "D#", "F#", "G#", "A#" };
		String[] lower = { "c", "d", "f", "g", "a" };

		for (int j = 0; j < hash.length; j++) {
			m = m.replaceAll(hash[j], lower[j]);
		}

		// musicinfos를 가공 ["곡 제목","재생시간에 맞춰 늘리거나 줄인 악보","총 재생시간"]
		String[][] infos = new String[musicinfos.length][3];
		for (int i = 0; i < musicinfos.length; i++) {
			String[] s = musicinfos[i].split(",");
			String[] startTime = s[0].split(":");
			int start = Integer.parseInt(startTime[0]) * 60 + Integer.parseInt(startTime[1]);

			String[] endTime = s[1].split(":");
			int end = Integer.parseInt(endTime[0]) * 60 + Integer.parseInt(endTime[1]);

			int totalTime = end - start;

			// # 처리
			for (int j = 0; j < hash.length; j++) {
				s[3] = s[3].replaceAll(hash[j], lower[j]);
			}
			String score = s[3];
			if (totalTime > s[3].length()) {
				score = s[3].repeat(totalTime / s[3].length());
				score += score.substring(0, totalTime % s[3].length());
			} else {
				score = s[3].substring(0, totalTime);
			}

			if (score.contains(m) && totalTime > maxTime) {
				answer = s[2];
				maxTime = totalTime;
			}
		}

		return answer;
	}

	
}