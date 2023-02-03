class Solution {
    int[] num;
    Set<Integer> set = new HashSet<>();

    public int arrayNesting(int[] nums) {
        num = nums;
        int longestLength = Integer.MIN_VALUE;

        for (int n : nums) {
            if (set.contains(n)) {
                continue;
            }
            int length = recur(n, 0);
            if (length > longestLength) {
                longestLength = length;
            }
        }
        return longestLength;
    }

    private int recur(int n, int count) {
        if (!set.contains(n)) {
            set.add(n);
            return recur(num[n], count + 1);
        } else {
            return count;
        }
    }
}