class Solution {
    public int[] solution(long n) {
        String s1 = Long.toString(n);
        String s2 = new StringBuilder(s1).reverse().toString();
        char[] arr = s2.toCharArray();
        
        int[] answer = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            answer[i] = arr[i] - '0';
        }    
        return answer;
    }
}