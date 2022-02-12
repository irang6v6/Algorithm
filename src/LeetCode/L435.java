package LeetCode;

import java.util.Arrays;

//https://leetcode.com/problems/non-overlapping-intervals/
//LeetCode 435. Non-overlapping Intervals 자바 풀이
//Greedy(회의실 최다배정 알고리즘),Sort

public class L435 {
	public static int eraseOverlapIntervals(int[][] intervals) {

		// 끝나는 값을 기준으로 오름차순 정렬
		Arrays.sort(intervals, (o1, o2) -> {
			if (o1[1] == o2[1]) {
				return Integer.compare(o1[0], o2[0]);
			} else {
				return Integer.compare(o1[1], o2[1]);
			}
		});

		// return: 몇 개를 삭제해야 하는가?
		int count = 0;
		int index = 0;

		for (int i = 1; i < intervals.length; i++) {
			// 뒷 회의가 시작되는 시간이 앞선 회의가 끝나는 시간보다 이르면 삭제(count++)
			if (intervals[index][1] > intervals[i][0]) {
				count++;
				continue;
			}
			// 그렇지 않다면 index를 현재 회의로 옮겨줌
			else if (intervals[index][1] <= intervals[i][0]) {
				index = i;
				continue;
			}
		}
		return count;
	}

//	public static void main(String[] args) {
//		int[][] arr = { { 0, 2 }, { 1, 3 }, { 2, 4 }, { 3, 5 }, { 4, 6 } };
//		System.out.println(eraseOverlapIntervals(arr));
//	}
}
