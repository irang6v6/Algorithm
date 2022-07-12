package SWEA;

import java.util.Scanner;

public class S1959 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int[] a = new int[sc.nextInt()];
			int[] b = new int[sc.nextInt()];

			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt();
			}

			for (int i = 0; i < b.length; i++) {
				b[i] = sc.nextInt();
			}
			int max = 0;

			if (a.length > b.length) {
				for (int i = 0; i < a.length - b.length + 1; i++) {
					int result = 0;
					for (int j = 0; j < b.length; j++) {
						result += a[i + j] * b[j];
					}
					max = Math.max(max, result);
				}
			} else if (a.length < b.length) {
				for (int i = 0; i < b.length - a.length+1; i++) {
					int result = 0;
					for (int j = 0; j < a.length; j++) {
						result += a[j] * b[i + j];
					}
					max = Math.max(max, result);
				}
			} else {
				int result = 0;
				for (int i = 0; i < a.length; i++) {
					result += a[i] * b[i];
				}
				max = Math.max(max, result);
			}
			System.out.printf("#" + test_case + " " + max);
			System.out.println();
		}
		sc.close();
	}
}
