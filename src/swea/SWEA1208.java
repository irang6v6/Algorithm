package swea;

import java.util.Scanner;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV139KOaABgCFAYh

public class SWEA1208 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		int result = 0;

		for (int test_case = 1; test_case <= T; test_case++) {
			int flatten = sc.nextInt(); // 평탄화 횟수
			int[] boxes = new int[100]; // 노란 상자의 개수는 100개로 고정
			for (int box = 0; box < boxes.length; box++) {// 모든 박스를 순회
				boxes[box] = sc.nextInt(); // 박스의 높이 저장
			}

			for (int f = 0; f < flatten; f++) { // 평탄화 횟수만큼
				result = flat(boxes);// flat() 메소드 호출
				if (result == 0 || result == 1) { // 평준화가 완료되었을때 호출 중지
					break;
				}
			}

			System.out.println("#" + test_case + " " + result); // 각 테스트케이스마다 출력
		}
		sc.close();
	}

	private static int flat(int[] boxes) { // 평탄화를 진행하는 메소드 flat
		int max = 0; // 최대 높이 박스의 인덱스를 저장할 변수
		int min = 0; // 최소 높이 박스의 인덱스를 저장할 변수

		for (int box = 0; box < boxes.length; box++) { // 박스 순회
			if (boxes[box] <= 100 && boxes[box] >= boxes[max]) {// 최대높이인 상자
				max = box;
			}
			if (boxes[box] >= 0 && boxes[box] <= boxes[min]) {// 최소높이인 상자
				min = box;
			}
		}
		if (boxes[max] == boxes[min]) { // 이미 평준화가 완료되어 최대=최소 일때
			return 0;
		}
		if (boxes[max] == boxes[min] + 1) { // 이미 평준화가 완료되어 최대-최소=1 일때
			return 1;
		}
		boxes[max]--; // 최대 상자 높이-1
		boxes[min]++; // 최소 상자 높이+1

		// 평준화가 된 상태에서 현재 최대높이와 최소높이를 찾아 차이를 구한다
		for (int box = 0; box < boxes.length; box++) { // 박스 순회
			if (boxes[box] <= 100 && boxes[box] >= boxes[max]) {// 최대높이인 상자
				max = box;
			}
			if (boxes[box] >= 0 && boxes[box] <= boxes[min]) {// 최소높이인 상자
				min = box;
			}
		}
		return boxes[max] - boxes[min]; // 최고점 - 최저점
	}
}
