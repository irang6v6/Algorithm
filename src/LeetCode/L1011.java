package LeetCode;

/*
Capacity To Ship Packages Within D Days
https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
이분탐색

컨베이어 벨트로 패키지를 D일 내에 운반해야 함. 컨베이어 벨트에 실어야하는 패키지의 최소 무게는?
입력된 weights 배열의 원소 순서대로만 실을 수 있음

초기 mid 설정을 배열의 총합/days로 시작해서 앞뒤로 1씩 움직이는게 좀더 간결할 것 같기도?

left=배열의 원소 중 가장 큰 값
right=배열의 원소의 합
*/

public class L1011 {
	public static int shipWithinDays(int[] weights, int days) {
		int answer = 0;
		int max = 0;
		int min = 0;

		// 변수명 주의
		for (int i = 0; i < weights.length; i++) {
			max += weights[i];
			if (weights[i] > min)
				min = weights[i];
		}

		while (min <= max) {
			int mid = min + (max - min) / 2;
			//System.out.println(min + " " + mid + " " + max);
			if (isPossible(weights, mid, days)) {
				answer = mid;
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		return answer;
	}

	private static boolean isPossible(int[] weights, int mid, int days) {
		int count = 1; // 안 나눈 상태가 1
		int sum = 0;

		for (int i = 0; i < weights.length; i++) {
			sum += weights[i];
			if (sum > mid) {
				count++;
				sum = weights[i];
			}
		}
		if (count <= days) {
			return true;
		}
		return false;
	}

//	public static void main(String[] args) {
//		int[] weights = { 10,50,100,100,50,100,100,100 };
//		int days = 5;
//
//		System.out.println(shipWithinDays(weights, days));
//	}
}
