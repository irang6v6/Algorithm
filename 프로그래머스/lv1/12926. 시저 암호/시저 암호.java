class Solution {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(Character c : s.toCharArray()){
            if(c==' '){
                sb.append(' ');
            } else {                
                int num = c + n;
                if(c >= 65 && c <= 90){ //A~Z
                    if(num > 90){
                        num = num - 26;
                    }
                }else if(c >= 97 && c <= 122){ //a~z
                    if(num > 122){
                        num = num - 26;
                    }
                }
                sb.append((char)num);
            }
        }
        return sb.toString();
    }
}