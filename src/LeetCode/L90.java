package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * https://leetcode.com/problems/subsets-ii/
 * 멱집합(부분집합+공집합) power set 구하기 
 * set, 재귀, 백트레킹 
 */

public class L90 {
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		Set<List<Integer>> list = new HashSet();
		subsetsBacktrack(list, new ArrayList(), nums, 0);
		return new ArrayList<>(list);
	}

	static void subsetsBacktrack(Set<List<Integer>> list, List<Integer> tmp, int[] nums, int start) {
		list.add(new ArrayList<>(tmp));
		for (int i = start; i < nums.length; i++) {
			tmp.add(nums[i]);
			subsetsBacktrack(list, tmp, nums, i + 1);
			tmp.remove(tmp.size() - 1);
		}
	}

//	public static void main(String[] args) {
//		int[] nums = { 1, 2, 2 };
//		List<List<Integer>> list = subsetsWithDup(nums);
//		System.out.println(list.toString());
//	}
}