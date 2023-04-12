package leetCode;

public class L151 {
	public static String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();
		s = s.replaceAll("\\s{2,}", " ");
		String[] str = s.split(" ");

		for (int i = str.length - 1; i >= 0; i--) {
			sb.append(str[i]).append(" ");
		}

		return sb.toString().trim();
	}

	public static void main(String[] args) {
		System.out.println(reverseWords("a good   example"));
	}
}
