package LeetCode;

public class numPairsDivisibleBy60 {
	public static int numPairsDivisibleBy60(int[] time) {
		// 합해서 60의 배수가 되는 두 곡의 쌍의 개수
		// 여러번 페어에 사용될 수 있음
		int[] remainder = new int[60];
		int count = 0;

		for (int i = 0; i < time.length; i++) {
			remainder[time[i] % 60]++;
		}

		// 경우의 수
		// 나머지가 0이나 30인 경우는 제외
		for (int i = 1; i < 30; i++) {
			count += remainder[i] * remainder[60 - i];
		}
		// 나머지가 0이나 30일때는 경우의 수 n*(n-1)/2
		count += remainder[0] * (remainder[0] - 1) / 2;
		count += remainder[30] * (remainder[30] - 1) / 2;

		return count;

	}

//	public static void main(String[] args) {
//		int[] time = { 30, 20, 150, 100, 40 };
//		System.out.println(numPairsDivisibleBy60(time));
//	}

}
