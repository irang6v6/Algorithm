package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class maxOperations {
	public int maxOperations(int[] nums, int k) {
		// 더해서 k가 되는 두 수를 배열에서 제거하고 그 횟수를 반환
		// 투포인터,해시테이블,배열,정렬
		// 해시맵
		// 연산의 최댓값을 구해야함
		// The number of such pairs equals to min(count(x), count(k-x)), unless that x =
		// k / 2, where the number of such pairs will be floor(count(x) / 2).
		if (k == 1) {
			return 0;
		}
		Map<Integer, Integer> count = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int v = nums[i];
			if (v < k) {
				count.put(v, count.getOrDefault(v, 0) + 1);
			}
		}
		int res = 0;
		for (int key : count.keySet()) {
			res += Math.min(count.getOrDefault(key, 0), count.getOrDefault(k - key, 0));
		}
		// 배열의 끝까지 돌기 때문에 중복횟수 제거
		return res / 2;
	}

}
