package LeetCode;

import java.util.Arrays;

/*세 개의 숫자의 합이 타겟과 가장 비슷한 경우의 합의 값을 반환
 *투포인터(Two Pointer),Sort,Array
 *포인터 3개 사용, gap으로 차이 비교 
 */

public class LC16 {
	public static int LC16(int[] nums, int target) {
		int gap = Integer.MAX_VALUE;
		int result = 0;
		int sum = 0;
		Arrays.sort(nums);

		// start,middle,end
		for (int s = 0; s < nums.length - 2; s++) {
			int m = s + 1;
			int e = nums.length - 1;

			while (m < e) {
				sum = nums[s] + nums[m] + nums[e];
				if (sum < target) {
					m++;
				} else if (sum > target) {
					e--;
				} else if (sum == target) {
					return sum;
				}
				if (Math.abs(target - sum) < gap) {
					gap = Math.abs(target - sum);
					result = sum;
				}
			}
		}
		return result;
	}

//	public static void main(String[] args) {
//		int[] arr = { -1, 1, 2, -4 };
//		System.out.println(LC16(arr, 1));
//	}
}

//threeSumClosest
