package leetCode;

public class L13 {
	public int romanToInt(String s) {
		// s를 순회하며 7가지의 케이스(+ IV,IX,XL,XC,CD,CM의 경우도 고려)별로 변환하는 int값을 누적
		/*
		Symbol       Value
		I             1
		V             5
		X             10
		L             50
		C             100
		D             500
		M             1000
		 */
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case 'I':
				result += 1;
				break;
			case 'V':
				if (i > 0 && s.charAt(i - 1) == 'I') {
					result += 3; //앞에서 이미 I값을 더했으니 제외하고 연산
				} else
					result += 5;
				break;
			case 'X':
				if (i > 0 && s.charAt(i - 1) == 'I') {
					result += 8;
				} else
					result += 10;
				break;
			case 'L':
				if (i > 0 && s.charAt(i - 1) == 'X') {
					result += 30;
				} else
					result += 50;
				break;
			case 'C':
				if (i > 0 && s.charAt(i - 1) == 'X') {
					result += 80;
				} else
					result += 100;
				break;
			case 'D':
				if (i > 0 && s.charAt(i - 1) == 'C') {
					result += 300;
				} else
					result += 500;
				break;
			case 'M':
				if (i > 0 && s.charAt(i - 1) == 'C') {
					result += 800;
				} else
					result += 1000;
				break;
			}
		}
		return result;
	}
}
