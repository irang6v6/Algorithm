package swea;

import java.util.Scanner;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GLXqKAWYDFAXB

public class SWEA2805 {

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int size = sc.nextInt();
			int[][] farm = new int[size][size]; // 밭 크기의 2차원 배열

			for (int i = 0; i < size; i++) {
				String str = sc.next();
				for (int j = 0; j < farm[i].length; j++) {
					farm[i][j] = (int) (str.charAt(j)) - 48; // 입력이 12345로 들어와서 문자 하나씩 떼서 저장했음
				}
			}

			// 땅을 절반씩 나눠서 수확물의 값을 더한다 (추수할 칸이 늘어나는 땅 / 줄어드는 땅)
			int crops = 0; // 수확량
			int yesHarvest = 1; // 몇 칸 추수할 수 있는지
			for (int i = 0; i < size / 2 + 1; i++) { // 5x5사이즈라면 3번째 줄까지 수확 (0,1,2)
				for (int j = size / 2 - i; j < size / 2 - i + yesHarvest; j++) { // [0,2],[1,1],[1,2]... 수확
					crops += farm[i][j];
				}
				yesHarvest += 2; // 추수할 칸을 양쪽으로 한칸씩 늘린다
			}

			// 현재 yesHarvest=7이므로 3칸으로 줄여줌
			yesHarvest -= 4;
			for (int i = size / 2 + 1; i < size; i++) { // 5x5사이즈라면 4번째 줄부터 수확 (3,4)
				for (int j = i - size / 2; j < i - size / 2 + yesHarvest; j++) { // [3,1],[3,2],[3,3]... 수확
					crops += farm[i][j];
				}
				yesHarvest -= 2; // 내려갈 수록 추수할 칸이 양쪽에서 한칸씩 줄어든다
			}
			System.out.println("#" + test_case + " " + crops);
		}
		sc.close();
	}

}
