import java.util.*;

class Solution {
    public int[] solution(String s) {
        int loop = 0;
        int removed = 0;
        while(!"1".equals(s)){
            loop++;
            int count = 0;
            for(char c : s.toCharArray()){
                if(c == '0') count++;
            }
            removed += count;
            s = Integer.toBinaryString(s.length() - count);
        }
        return new int[] { loop, removed };
    }
}