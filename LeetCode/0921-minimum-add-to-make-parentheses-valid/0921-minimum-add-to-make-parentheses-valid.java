public class Solution {
    public static int minAddToMakeValid(String s) {
        int answer = 0; //남는 괄호 수
        int openingParenthesis = 0; //여는 괄호 수

        for (Character c : s.toCharArray()) {
            if (c == '(') { //여는 괄호
                openingParenthesis++;
            } else { //닫는 괄호
                if (openingParenthesis > 0) {
                    openingParenthesis--;
                } else {
                    answer++; //열리지 못한 ')'
                }
            }
        }
        answer += openingParenthesis; //닫히지 못한 '('
        return answer;
    }
}
