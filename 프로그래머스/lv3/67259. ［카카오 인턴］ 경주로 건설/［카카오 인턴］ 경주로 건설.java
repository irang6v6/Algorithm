import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

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
        int[][][] visited = new int[N][N][4]; //누적 요금을 저장해서 visited를 대신함
        for (int[][] row : visited) {//방향 당 요금이 더 적을때만 갱신되어야 함
            for (int[] row2 : row) {
                Arrays.fill(row2, Integer.MAX_VALUE);
            }
        }

        for (int i = 0; i < 4; i++) {
            visited[0][0][i] = 0;
        }
        int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0}; //우하좌상->(0,2),(1,3)끼리가 직선

        Queue<Pos> queue = new ArrayDeque<>();

        queue.add(new Pos(0, 0, -1));
        while (!queue.isEmpty()) {
            Pos cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];
                int nextD = i;
                int nextPrice = 0;

                if (cur.d < 0 || Math.abs(cur.d - i) == 2 || cur.d == i) {//100원 일때
                    if (cur.d < 0) {
                        nextPrice = 100;
                    } else {
                        nextPrice = visited[cur.x][cur.y][cur.d] + 100;
                    }
                } else {
                    nextPrice = visited[cur.x][cur.y][cur.d] + 600;
                }

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || nextPrice > visited[nextX][nextY][nextD] || board[nextX][nextY] == 1)
                    continue;

                visited[nextX][nextY][nextD] = nextPrice;
                queue.add(new Pos(nextX, nextY, nextD));
            }
        }

        for (int i = 0; i < 4; i++) {
            if (minSum > visited[N - 1][N - 1][i]) {
                minSum = visited[N - 1][N - 1][i];
            }
        }

        return minSum;
    }
}
