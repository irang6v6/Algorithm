class Solution {
    public static int[] solution(int[] numbers) {
        int[] answers = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            answers[i] = numbers[i];
        }
        answers[answers.length - 1] = -1;

        for (int i = numbers.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] < numbers[j]) {
                    answers[i] = numbers[j];
                    break;
                } else if (numbers[i] >= numbers[j]) {
                    if (answers[j] == -1) {
                        answers[i] = -1;
                        break;
                    } else if (answers[i] < answers[j]) {
                        answers[i] = answers[j];
                        break;
                    }
                }
            }
        }
        return answers;
    }
}