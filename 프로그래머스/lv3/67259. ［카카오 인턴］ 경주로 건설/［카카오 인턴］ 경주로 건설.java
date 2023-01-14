
class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1}; //상,하,좌,우
    static int N, answer;
    static int[][] map;
    static boolean[][] visited;

    static class Pos {
        int r, c, cost, direction;

        public Pos(int r, int c, int cost, int direction) {
            this.r = r;
            this.c = c;
            this.cost = cost;
            this.direction = direction;
        }
    }

    public static int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        N = board.length - 1;
        map = board;
        visited = new boolean[N + 1][N + 1];

        visited[0][0] = true;
        dfs(new Pos(0, 0, 0, 4));

        return answer;
    }

    private static void dfs(Pos cur) {
        if (cur.r == N && cur.c == N) {
            if (answer > cur.cost) {
                answer = cur.cost;
            }
            return;
        }

        if (cur.cost > answer) {
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = cur.r + dx[i];
            int nextY = cur.c + dy[i];
            int nextCost = 0;

            if (nextX < 0 || nextX > N || nextY < 0 || nextY > N || visited[nextX][nextY] || map[nextX][nextY] == 1) {
                continue;
            }

            if (cur.direction == i || cur.direction == 4 || Math.abs(cur.direction - i) == 2) {
                nextCost = cur.cost + 100;
            } else {
                nextCost = cur.cost + 600;
            }
            
            if (nextCost > answer) {
                return;
            }

            visited[nextX][nextY] = true;
            dfs(new Pos(nextX, nextY, nextCost, i));
            visited[nextX][nextY] = false;
        }
    }
}
