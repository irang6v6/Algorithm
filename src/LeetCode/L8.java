package LeetCode;

/*
 * https://leetcode.com/problems/string-to-integer-atoi/
 * 주어진 문장에서 공백, 문자 떼고 (+,- 기호는 남기고) 숫자만 int형으로 리턴 
 * step1. 문장 앞의 공백 제거 
 * step2. 첫글자가 +나 -인 경우 
 * step3. 숫자가 아닌 문자 나오거나 문장이 끝날때까지 쭉 탐색. 
 * step4. 이 숫자들을 int로 형변환. int범위를 넘어서는 숫자일 경우 int 최댓값이나 최솟값으로 바꿔줌 / 문장에 숫자가 없으면 0 
 * 
 * string을 char 단위로 돌면서 공백/+-/숫자 검사를 해야 할듯, 순서가 중요함 
 * int는 null일 수 없어서 string으로 검사
 */
public class L8 {
	public static int myAtoi(String s) {
		int length = s.length();
		StringBuilder sb = new StringBuilder();
		int answer=0;	

		int index = 0;
		
		//공백
		while (index < length && s.charAt(index) == ' ') {
			index++;
		}

		//기호
		if (index < length && s.charAt(index) == '+') {
			sb.append(s.charAt(index));
			index++;
		} else if(index < length &&s.charAt(index) == '-') {
			sb.append(s.charAt(index));
			index++;
		}
		
		//숫자
		int countDigit = 0;
		while (index < length && Character.isDigit(s.charAt(index))) {
			sb.append(s.charAt(index));
			index++;
			countDigit++;
		}

		if (countDigit == 0) {
			return 0;
		}

		//overflow/underflow 검사, 형변환 
		String tmp = sb.toString();
		if (tmp == "") {
			answer = 0;
		} else {
			try {
				answer = Integer.parseInt(tmp);
			} catch (NumberFormatException e) {
				if (tmp.charAt(0) == '-') {
					answer = Integer.MIN_VALUE;
				} else {
					answer = Integer.MAX_VALUE;
				}
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		String s = " +-12";
		System.out.println(myAtoi(s));
	}
}