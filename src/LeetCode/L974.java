package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class L974 {
	public static int subarraysDivByK(int[] nums, int k) {
		int answer = 0;
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		
		for (int i = 0; i < nums.length; i++) {
			sum = (sum + nums[i]) % k;
			if (sum < 0) {
				sum += k;
			} 
			answer += map.getOrDefault(sum, 0);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] nums = { 4, 5, 0, -2, -3, 1 };
		int k = 5;

		System.out.println(subarraysDivByK(nums, k));
	}
}
