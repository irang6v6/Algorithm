import java.util.PriorityQueue;

public class Solution {
    public static String largestNumber(int[] nums) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (Long.parseLong(o1 + o2) > Long.parseLong(o2 + o1)) {
                return -1;
            } else {
                return 1;
            }
        });

        for (int i : nums) {
            priorityQueue.add(Long.toString(i));
        }

        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            sb.append(priorityQueue.poll());
        }

        String answer = sb.toString();
        if (answer.charAt(0) == '0') {
            return "0";
        } else {
            return answer;
        }
    }

}
