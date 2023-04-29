import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(!"1".equals(s)){
            answer[0]++;
            for(char c : s.toCharArray()){
                if(c=='0') answer[1]++;
            }
            s = s.replaceAll("0","");
            int len = s.length();
            s = Integer.toBinaryString(len);
        }
       
        return answer;
    }
}