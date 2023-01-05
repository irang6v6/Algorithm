import java.util.TreeMap;
import java.util.Map;

class Solution {
    public static int findKthLargest(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        int index = 0;
        int order = nums.length - k + 1;
        for (int key : map.keySet()) {
            index += map.get(key);
            if (index >= order) {
                return key;
            }
        }
        return 0;
    }
}
