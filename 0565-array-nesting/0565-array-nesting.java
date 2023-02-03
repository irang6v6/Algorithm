class Solution {
    int[] num;

    public int arrayNesting(int[] nums) {
        num = nums;
        int longestLength = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) {
                continue;
            }
            int length = recur(nums[i], 0);
            if (length > longestLength) {
                longestLength = length;
            }
        }
        return longestLength;
    }

    private int recur(int index, int count) {
        if (num[index] != -1) {
            int next = num[index];
            num[index] = -1;
            return recur(next, count + 1);
        } else {
            return count;
        }
    }
}