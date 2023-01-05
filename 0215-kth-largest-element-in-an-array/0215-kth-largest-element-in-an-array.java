class Solution {
    public static int findKthLargest(int[] nums, int k) {
        int[] count = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i] + 10000]++;
        }

        int index = 0;
        int order = nums.length - k + 1;
        for (int i = 0; i < count.length; i++) {
            index += count[i];
            if (index >= order) {
                return i - 10000;
            }
        }
        return 0;
    }
}
