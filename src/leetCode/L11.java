package leetCode;

public class L11 {
	public int maxArea(int[] height) {

		int line1 = 0;
		int line2 = height.length - 1;
		int maxWater = 0;
		// 투포인터
		while (line1 < line2) {
			int x = line2 - line1;
			int y = height[line1] < height[line2] ? height[line1] : height[line2];
			int water = x * y;

			maxWater = water > maxWater ? water : maxWater;

			if (height[line1] > height[line2]) {
				line2--;
			} else
				line1++;
		}
		return maxWater;
	}
}
