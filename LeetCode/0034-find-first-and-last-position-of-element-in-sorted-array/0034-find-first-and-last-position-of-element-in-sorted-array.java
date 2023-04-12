import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    List<Integer> arr = new ArrayList<>();
    int[] num;

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return new int[]{0, 0};
            } else {
                return new int[]{-1, -1};
            }
        }

        num = nums;

        binarySearch(target, 0, nums.length-1);
        Collections.sort(arr);
        if (arr.size() != 0) {
            return new int[]{arr.get(0), arr.get(arr.size() - 1)};
        } else {
            return new int[]{-1, -1};
        }
    }

    private int binarySearch(int target, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (num[mid] == target) {
                arr.add(mid);
                binarySearch(target, low, mid - 1);
                binarySearch(target, mid + 1, high);
            } else if (target < num[mid]) {
                return binarySearch(target, low, mid - 1);
            } else {
                return binarySearch(target, mid + 1, high);
            }
        }
        return -1;
    }
}
