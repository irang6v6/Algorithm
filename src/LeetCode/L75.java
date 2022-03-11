package LeetCode;

/*
 * https://leetcode.com/problems/sort-colors/
 * 2-pass 
 * 0,1,2 각각의 원소 개수를 세고 원소 갯수만큼 원본 배열을 overwriting한다. 
 */

public class L75 {
	public static void sortColors(int[] nums) {

		int zero = 0;
		int one = 0;
		int two = 0;

		for (int i : nums) {
			if (i == 0) {
				zero++;
			}
			if (i == 1) {
				one++;
			}
			if (i == 2) {
				two++;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (i < zero) {
				nums[i] = 0;
			} else if (i < zero + one) {
				nums[i] = 1;
			} else {
				nums[i] = 2;
			}
		}

	}

//	public static void main(String[] args) {
//		int[] nums = { 2, 0, 2, 1, 1, 0 };
//		sortColors(nums);
//		for (int i : nums) {
//			System.out.println(i);
//		}
//	}
}
