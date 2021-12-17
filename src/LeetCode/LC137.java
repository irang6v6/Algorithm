package LeetCode;

import java.util.Arrays;
import java.util.HashMap;

public class LC137 {
	//배열 안에 같은 숫자가 3개씩 들어있는데, 1개만 들어있는 숫자가 하나 있음. 이것을 찾아라
	//hash map 사용
	public static int LC137(int[] nums) {
		HashMap<Integer, Integer> map=new HashMap<Integer,Integer>();

		for(int i=0;i<nums.length;i++) {
			if(!map.containsKey(nums[i])) {
				map.put(nums[i], 1);
			}else {
				map.put(nums[i], map.get(nums[i])+1);
			}
		}

		for(int i=0;i<nums.length;i++) {
			if(map.get(nums[i])==1) {
				return nums[i];
			}
		}
		return -1;
	}

//	public static void main(String[] args) {
//		int[] arr= {1,2,2,2,4,4,4,5};
//		Arrays.sort(arr);
//
//		System.out.println(LC137(arr));
//	}
}
