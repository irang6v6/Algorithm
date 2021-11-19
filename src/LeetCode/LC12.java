package LeetCode;

public class LC12 {
	// Integer to Roman
	public static String LC12(int num) {
		String result = "";
		while (num >= 1000) {
			num -= 1000;
			result += "M";
		}
		while (num < 1000 && num >= 500) {
			if (num / 100 == 9) {
				result += "CM";
				num -= 900;
			} else {
				num -= 500;
				result += "D";
			}
		}
		while (num < 500 && num >= 100) {
			if (num / 100 == 4) {
				result += "CD";
				num -= 400;
			} else {
				num -= 100;
				result += "C";
			}
		}
		while (num < 100 && num >= 50) {
			if (num / 10 == 9) {
				result += "XC";
				num -= 90;
			} else {
				num -= 50;
				result += "L";
			}
		}
		while (num < 50 && num >= 10) {
			if (num / 10 == 4) {
				result += "XL";
				num -= 40;
			} else {
				num -= 10;
				result += "X";
			}
		}
		while (num < 10 && num >= 5) {
			if (num / 1 == 9) {
				result += "IX";
				num -= 9;
			} else {
				num -= 5;
				result += "V";
			}
		}
		while (num < 5 && num >= 1) {
			if (num / 1 == 4) {
				result += "IV";
				num -= 4;
			} else {
				num -= 1;
				result += "I";
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(LC12(1994));
	}

}
