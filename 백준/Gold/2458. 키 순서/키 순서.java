import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]);// 학생 수
		int M = Integer.parseInt(input[1]); // 키 비교 횟수
		int[][] students = new int[N + 1][N + 1];// 인접매트릭스
		
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			// 키가 작은 학생 (인덱스 1부터), 키가 큰 학생 (인덱스 1부터)
			students[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = 1;
		}
		// 플로이드 워셜 알고리즘 수행
		for (int k = 1; k < N + 1; k++) {
			for (int i = 1; i < N + 1; i++) {
				if (i == k)
					continue;// a학생과 경유 학생과 달라야함
				for (int j = 1; j < N + 1; j++) {
					if (i == j || j == k)
						continue;// 경유 학생과 목적 학생이 같거나 출발지가 곧 목적지라면 패스
					if (students[i][k] == 1 && students[k][j] == 1) { // 비교할 수 있는 관계면
						students[i][j] = 1; // 저장
					}
				}
			}
		}

		int answer = 0;// 자신의 키가 몇번째인지 알 수 있는 학생 수
		for (int i = 1; i < students.length; i++) {
			int count = 0;// 비교 된 횟수 카운트
			for (int j = 1; j < students.length; j++) {
				count += students[i][j];// i가 j보다 작은 비교가 있었으면 카운트 증가
				count += students[j][i]; // i가 j보다 큰 비교가 있었으면 카운트 증가
			}
			if (count == N - 1) {
				answer++;// i가 포함된 비교횟수가 학생 인원수-1이면 자신의 키가 몇번째인지 알수 있으므로 answer 증가
			}
		}

		System.out.println(answer);
	}
}
