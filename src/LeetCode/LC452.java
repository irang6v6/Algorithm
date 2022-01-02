package LeetCode;

import java.util.Arrays;

/*
 * Minimum Number of Arrows to Burst Balloons
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 * Greedy,Array,Sorting
 * 최소 횟수로 모든 풍선을 터트리기 - end point값으로 정렬해서 첫번째 풍선의 end로 화살을 쏘고 다음 풍선으로 반복
 * 2차원배열의 정렬 - Arrays.sort(array, Comparator.comparingDouble(o -> o[0]));
 * 
 */
public class LC452 {
	public static int findMinArrowShots(int[][] points) {
		Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

		int end = points[0][1];
		int arrows = 1;

		//두번째 풍선부터 
		for(int i=1; i<points.length; i++){
			if(points[i][0] > end){
				arrows++;
				end = points[i][1];
			}
		}

		return arrows;
	}
	

	public static void main(String[] args) {
		int[][] arr={{1,2},{3,4},{5,6},{7,8}};
		System.out.println(findMinArrowShots(arr));
	}

}
