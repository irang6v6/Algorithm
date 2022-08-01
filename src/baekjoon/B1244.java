package baekjoon;

import java.util.Scanner;

//https://www.acmicpc.net/problem/1244

public class B1244 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] switches = new int[sc.nextInt() + 1];
		for (int i = 1; i < switches.length; i++) {
			switches[i] = sc.nextInt();
		}

		int[][] students = new int[sc.nextInt()][2];

		for (int i = 0; i < students.length; i++) {
			for (int j = 0; j < 2; j++) {
				students[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < students.length; i++) {
			int gender = students[i][0];
			if (gender == 1) { // 남학생
				int boyNum = students[i][1];
				for (int j = boyNum; j < switches.length; j++) {
					if (j % boyNum == 0) {
						switches[j] = switches[j] == 0 ? 1 : 0;
					}
				}
			} else if (gender == 2) { // 여학생
				int girlNum = students[i][1];
				switches[girlNum] = switches[girlNum] == 0 ? 1 : 0;
				int left = girlNum - 1;
				int right = girlNum + 1;
				while (left > 0 && right < switches.length) {
					if (switches[left] == switches[right]) {
						switches[left] = switches[left] == 0 ? 1 : 0;
						switches[right] = switches[left];
						left--;
						right++;
					} else {
						break;
					}
				}
			}
		}

		for (int j = 1; j < switches.length; j++) {
			if (j % 20 == 1) {
				System.out.println();
			}
			System.out.print(switches[j] + " ");
		}
		sc.close();
	}
}
