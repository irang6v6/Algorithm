class Solution {
    static class Pos {
        int x, y, d;

        public Pos(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static int solution(int[][] board) {
        int minSum = Integer.MAX_VALUE;
        int N = board.length;
        int[][][] dp = new int[N][N][4]; //4가지 방향에서 오는 누적값을 따로따로 저장함
        for (int[][] row1 : dp) {//방향 당 요금이 더 적을때만 갱신되어야 함
            for (int[] row2 : row1) {
                Arrays.fill(row2, Integer.MAX_VALUE);
            }
        }

        for (int i = 0; i < 4; i++) { //출발자점 0원으로 세팅
            dp[0][0][i] = 0;
        }

        int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0}; //우하좌상->(0,2),(1,3)끼리가 직선

        Queue<Pos> queue = new ArrayDeque<>();

        queue.add(new Pos(0, 0, -1));//시작점은 이전 방향이 없으므로 d : -1
        while (!queue.isEmpty()) {
            Pos cur = queue.poll();

            for (int nextD = 0; nextD < 4; nextD++) {
                int nextX = cur.x + dx[nextD];
                int nextY = cur.y + dy[nextD];
                int nextPrice = 0;

                if (cur.d < 0) {
                    nextPrice = 100;
                } else if (cur.d < 0 || Math.abs(cur.d - nextD) == 2 || cur.d == nextD) {//100원 일때
                    nextPrice = dp[cur.x][cur.y][cur.d] + 100;
                } else {
                    nextPrice = dp[cur.x][cur.y][cur.d] + 600;
                }

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || nextPrice > dp[nextX][nextY][nextD] || board[nextX][nextY] == 1)
                    continue;

                dp[nextX][nextY][nextD] = nextPrice;
                queue.add(new Pos(nextX, nextY, nextD));
            }
        }

        for (int i = 0; i < 4; i++) {
            if (minSum > dp[N - 1][N - 1][i]) {
                minSum = dp[N - 1][N - 1][i];
            }
        }

        return minSum;
    }
}
