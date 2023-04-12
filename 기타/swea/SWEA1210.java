package swea;

import java.util.Scanner;

//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14ABYKADACFAYh

public class SWEA1210 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int TC = sc.nextInt();
			int[][] ladder = new int[100][100]; // 100x100의 배열
			boolean[][] visited = new boolean[100][100]; // 같은 곳을 두번 방문하지 않도록 확인

			for (int i = 0; i < 100; i++) { // 사다리 0,1값 입력받아 ladder[][]에 세팅
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = sc.nextInt();
				}
			}

			// 도착점을 찾아 밑에서 위로 올라감
			int end = 0;
			for (int i = 0; i < 100; i++) {
				if (ladder[99][i] == 2) { // 맨 밑 99번째 줄에서 값이 2인 원소를 찾아 인덱스를 저장
					end = i;
				}
			}

			int x = 99; // 도착점의 x좌표
			int y = end; // 도착점의 y좌표
			while (x > 0) { // 출발점에 도착할 때까지 반복
				visited[x][y] = true; // 현재 좌표를 방문했다고 표시
				if (y > 0 && visited[x][y - 1] == false && ladder[x][y - 1] == 1) {
					y -= 1; // 왼쪽 노드를 이전에 방문 안함 && 길이 있음
				} else if (y < 99 && visited[x][y + 1] == false && ladder[x][y + 1] == 1) {
					y += 1;// 오른쪽 노드를 이전에 방문 안함 && 길이 있음
				} else if (visited[x - 1][y] == false && ladder[x - 1][y] == 1) {
					x -= 1;// 위쪽 노드를 이전에 방문 안함 && 길이 있음
				}
			}
			System.out.println("#" + TC + " " + y); // 테스트케이스와 ladder[0][y]에서 y값 출력
		}
		sc.close();
	}

}
