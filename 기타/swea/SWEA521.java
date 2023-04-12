package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA521 {

	static int L; // 칼로리
	static int N; // 재료 수
	static int maxT;// 가장 맛있는 조합
	static int[][] foods; // [재료의 맛][칼로리]

	static void subset(int index, int totalC, int totalT) {// 칼로리, 맛

		if (totalC > L) //조합을 구하다가 제한 칼로리를 넘어서면 바로 리턴
			return;
		if (index == N) { //부분조합을 구했을때
			if (totalC <= L) //총 칼로리가 제한 칼로라보다 낮고
				maxT = maxT < totalT ? totalT : maxT;//맛 점수가 maxT보다 높으면 갱신
			return;
		}

		subset(index + 1, totalC + foods[index][1], totalT + foods[index][0]); //재료 골랐을때
		subset(index + 1, totalC, totalT); //안골랐을때
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine()); // 시간복잡도 2^n n이 최대 20이기때문에 가능!

		for (int test_case = 1; test_case <= T; test_case++) {
			String[] inputs = br.readLine().split(" ");
			N = Integer.parseInt(inputs[0]);
			L = Integer.parseInt(inputs[1]); // 칼로리
			maxT = 0;

			foods = new int[N][2];

			for (int i = 0; i < N; i++) {
				inputs = br.readLine().split(" ");
				foods[i][0] = Integer.parseInt(inputs[0]);// 맛
				foods[i][1] = Integer.parseInt(inputs[1]);// 칼로리
			}
			// ----------- 입력끝 -------------/
			subset(0, 0, 0);

			/*----------- 출력 -------------*/
			bw.write("#" + test_case + " " + maxT + "\n");
		}
		bw.flush();
		br.close();
		bw.close();
	}
}
