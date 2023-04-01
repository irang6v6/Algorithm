import java.util.Arrays;

class Solution {
    public int solution(int x, int y, int n) {

        //x,y를 그대로 인덱스로 사용하기 위해 y+1 크기의 배열 선언
        int[] dp = new int[y * 4];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[x] = 0;

        for (int i = x; i < y + 1; i++) {

            //x에서부터 만들 수 없는 수
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }

            //최소 연산 횟수 갱신
            dp[i + n] = dp[i] + 1 < dp[i + n] ? dp[i] + 1 : dp[i + n];
            dp[i * 2] = dp[i] + 1 < dp[i * 2] ? dp[i] + 1 : dp[i * 2];
            dp[i * 3] = dp[i] + 1 < dp[i * 3] ? dp[i] + 1 : dp[i * 3];
        }

        int answer = dp[y];
        if (dp[y] == Integer.MAX_VALUE) {
            answer = -1;
        }
        return answer;
    }
}