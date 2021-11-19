package Programmers;

import java.util.Arrays;

//프로그래머스 - 정수 삼각형 (https://programmers.co.kr/learn/courses/30/lessons/43105#)
//삼각형 행렬에서 꼭대기에서 바닥까지 이어지는 경로 중, 거쳐간 숫자의 합이 가장 큰 경우를 찾아보자 
//DP 
//nxn행렬의 경우는 쉬운데 이 문제의 경우 2차원 배열의 형태가 삼각형임 -> 말이 삼각형이지 계단식 	
//(n+1)x(n+1)의 사각형 2차원배열을 만들고 Math.max(대각선위,바로 위)+triangle원래 값 해서 덧셈 결과가 저장된 배열 c를 만든 뒤 막줄에서 가장 큰 값을 찾아 return 함 
//정확성, 효율성 모두 만점 6v6

public class IntegerTriangle {

	static int IntegerTriangle(int[][] triangle) {
		int answer = 0;
		int n = triangle.length + 1;
		int[][] c = new int[n][n];

		// 초기화 안하면 0이기 때문에 양옆,위 빈곳은 냅둠

		//원래값+더 큰 값 
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= i; j++) {
				c[i][j] = triangle[i - 1][j - 1] + Math.max(c[i - 1][j - 1], c[i - 1][j]);
			}
		}

		//맨 밑줄(합계)중에 가장 큰 값 구하기 
		for (int i = 0; i < n; i++) {
			if (answer < c[n - 1][i])
				answer = c[n - 1][i];
		}

		return answer;
	}

	public static void main(String[] args) {
		int[][] triangle = { { 7 }, { 30, 8 } };
		System.out.println(IntegerTriangle(triangle));
	}

}
