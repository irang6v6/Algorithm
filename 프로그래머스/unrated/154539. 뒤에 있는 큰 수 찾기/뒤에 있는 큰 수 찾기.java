import java.util.*;

class Solution {
    public static int[] solution(int[] numbers) {
        int[] answers = new int[numbers.length];
        Arrays.fill(answers, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            while(!stack.isEmpty() && numbers[stack.peek()]<numbers[i]){
                answers[stack.pop()]=numbers[i];
            }
            stack.push(i);
        }
        return answers;
    }
}