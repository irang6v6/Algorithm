package SWEA;

import java.util.Scanner;

public class S1979 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			
			int n = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int answer = 0;
			for (int i = 0; i < n; i++) {
				int count = 0;
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == 1) {
						count++;
					} else {
						if (count == k) {
							answer++;
						}
						count = 0;
					}
				}
				if (count == k) {
					answer++;
				}
			}
			for (int i = 0; i < n; i++) {
				int count = 0;
				for (int j = 0; j < n; j++) {
					if (arr[j][i] == 1) {
						count++;
					} else {
						if (count == k) {
							answer++;
						}
						count = 0;
					}
				}
				if (count == k) {
					answer++;
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}
		sc.close();
	}
}
