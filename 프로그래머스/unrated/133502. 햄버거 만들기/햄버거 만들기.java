public class Solution {
    public static int solution(int[] ingredient) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ingredient.length; i++) {
            sb.append(ingredient[i]);
            if (sb.length() >= 4 && "1231".equals(sb.substring(sb.length() - 4, sb.length()))) {
                sb.delete(sb.length() - 4, sb.length());
                answer++;
            }
        }
        return answer;
    }

}
