import java.io.IOException;
import java.util.*;

public class Solution {
    public static int[] maxSubsequence(int[] nums, int k) {
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            arr.add(new int[]{nums[i], i});
        }

        arr.sort((o1, o2) -> {
            return o2[0] - o1[0];
        });

        while (arr.size() > k) {
            arr.remove(arr.size() - 1);
        }

        arr.sort((o1, o2) -> {
            return o1[1] - o2[1];
        });

        int[] answer = new int[k];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i)[0];
        }
        return answer;
    }

}
