package LeetCode;

import java.util.Arrays;

public class LC169 {
	public static int majorityElement(int[] nums) {

		int n = nums.length;
		int mid = n / 2;

		Arrays.sort(nums);
		int answer = nums[mid];

		return answer;
	}
	
	public static void main(String[] args) {
		int[] arr= {2,2,1,1,1,2,2};
		System.out.println(majorityElement(arr));
	}
	
	//Boyer-Moore Voting Algorithm 숫자 하나하나마다 같으면 +1, 다르면 -1 하면서 상쇄시켜나감 
//	public int majorityElement(int[] nums) {
//        int count = 0;
//        Integer candidate = null;
//
//        for (int num : nums) {
//            if (count == 0) {
//                candidate = num;
//            }
//            count += (num == candidate) ? 1 : -1;
//        }
//
//        return candidate;
//    }
}
