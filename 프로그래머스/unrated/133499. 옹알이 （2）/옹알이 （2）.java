

class Solution {
    public static int solution(String[] babbling) {
        int answer = 0;
        String[] possible = {"aya", "ye", "woo", "ma"};
        for (String s1 : babbling) {
            for (String s2 : possible) {
                //중복검사
                if (s1.contains(s2.repeat(2))) {
                    continue;
                } else {
                    //발음할 수 없는 문자 검사
                    s1 = s1.replaceAll(s2, " ");
                }
            }
            System.out.println("s1: " + s1);
            if ("".equals(s1.trim())) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int k = 4;
        int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
        String[] babbling = {"ayaye", "uuu", "yewooye", "yemawoo", "ayaayaa","myea"};
        System.out.print(solution(babbling));
    }
}
