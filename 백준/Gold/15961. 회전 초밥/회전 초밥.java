import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]); // 회전 초밥 벨트에 놓인 접시의 수
		int d = Integer.parseInt(input[1]); // 초밥의 가짓수
		int k = Integer.parseInt(input[2]); // 연속해서 먹는 접시의 수
		int c = Integer.parseInt(input[3]); // 쿠폰 번호

		int[] everySushi = new int[d + 1]; // 총 스시 종류, 스시번호가 인덱스로 사용, 내가 먹을 스시의 종류를 세는데 사용
		int[] sushiTable = new int[N]; // 회전테이블에 있는 스시. k개씩 잘라서 개수 세야함

		for (int n = 0; n < N; n++) {
			sushiTable[n] = Integer.parseInt(br.readLine());
		} // 입력

		int max = 0; // answer

		int count = 0;
		for (int i = 0; i < k; i++) { // 초기값 셋팅. 0~k까지 초밥 가짓수,종류 저장
			if (everySushi[sushiTable[i]] == 0) {
				count++;
			}
			everySushi[sushiTable[i]]++;
		}
		max = count;

		for (int s = 0; s <= N - 1; s++) { // 연속된 접시의 시작점
			if (count >= max) {
				if (everySushi[c] == 0) {
					max = count + 1;
				} else {
					max = count;
				}
			}

			everySushi[sushiTable[s]]--; //시작점 초밥 제외
			if (everySushi[sushiTable[s]] == 0) //종류가 줄었는지 확인
				count--;

			if (everySushi[sushiTable[(s + k) % N]] == 0) { //다음에 포함될 초밥이 전에 없던 종류인지 확인
				count++;
			}
			everySushi[sushiTable[(s + k) % N]]++; //끝점+1 초밥 포함

		}

		System.out.println(max);
	}
}
