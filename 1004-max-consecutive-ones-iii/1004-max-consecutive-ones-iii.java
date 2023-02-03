import java.util.Arrays;

class Solution {

    public static int longestOnes(int[] nums, int k) {
        int maxLength = Integer.MIN_VALUE;

        //1. 0의 개수 구하기
        int count = 0;
        for (int i : nums) {
            if (i == 0) {
                count++;
            }
        }

        //2. 각 0의 인덱스 구하기
        int[] zero = new int[count];
        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero[idx++] = i;
            }
        }

        if (k > count) {
            k = count;
        }
        if (k == count) {
            return nums.length;
        }

        //3. sliding windows 기법으로 연속 k개씩 1로 바꾸기
        for (int i = 0; i <= zero.length - k; i++) {
            int[] copy = nums.clone();
            for (int j = 0; j < k; j++) {
                copy[zero[i + j]] = 1;
            }

            //index 범위 넘어가지 않도록 처리
            int start = (i - 1) < 0 ? -1 : zero[i - 1];
            int end = (i + k) > (zero.length - 1) ? nums.length : zero[i + k];

            int length = end - start - 1;
            if (length > maxLength) {
                maxLength = length;
            }
        }
        return maxLength;
    }
}
