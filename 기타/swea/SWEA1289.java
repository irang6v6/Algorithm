package swea;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA1289 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			String memory = sc.next();
			char[] mToChar = memory.toCharArray();
			char[] init = new char[memory.length()];
			Arrays.fill(init, '0');

			int count = 0;
			for (int i = 0; i < memory.length(); i++) {
				if (mToChar[i] != init[i]) {
					Arrays.fill(init, i, init.length, mToChar[i]);
					count++;
				}
			}
			System.out.print("#" + test_case + " " + count);
			System.out.println();
		}
		sc.close();
	}
}
