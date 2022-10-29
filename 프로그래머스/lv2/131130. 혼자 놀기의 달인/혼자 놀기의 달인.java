import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	static int totalCards, maxScore;
	static boolean[] opened;
	static int[] card;

	public static int solution(int[] cards) {

		for (int i = 0; i < cards.length; i++) {
			cards[i] -= 1;
		}

		card = cards;
//		System.out.println(Arrays.toString(card));
		totalCards = cards.length;
		opened = new boolean[totalCards];
		maxScore = Integer.MIN_VALUE;

		// 랜덤으로 두 장 뽑아서 게임 진행
		int[] pick = new int[2];
		comb(0, 0, pick);

		return maxScore;
	}

	private static void comb(int start, int cnt, int[] pick) {
		if (cnt == 2) {
//			System.out.println(Arrays.toString(pick));
			play(pick);
			return;
		}

		for (int i = start; i < totalCards; i++) {
			pick[cnt] = i;
			comb(i, cnt + 1, pick);
		}

	}

	private static void play(int[] pick) {
		// 게임
//		System.out.println(Arrays.toString(pick));
		int[] score = { 0, 0 };
		opened = new boolean[totalCards + 1];
		for (int i = 0; i < 2; i++) {
			int cur = pick[i];
//			System.out.println("firstPick: " + cur);
			while (!opened[cur]) {
                score[i]++;
				opened[cur] = true;
				int next = card[cur];
				if (opened[next])
					break;
				cur = next;
//				System.out.println("Pick: " + cur);
				
			}
		}
		int gameScore = score[0] * score[1];
//		System.out.println(gameScore);
		maxScore = gameScore > maxScore ? gameScore : maxScore;

	}


}
