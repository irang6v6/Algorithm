import java.util.*;

class Solution {
    static int num;
    static String[][] map;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0}; //우하좌상

    public static int[] solution(String[] maps) {
        //maps가공함
        map = new String[maps.length][];
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].split("");
        }

        //maps를 순회하다가
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                //X칸이면 그냥 넘어가고 숫자면 BFS에 집어넣음
                if (!"X".equals(map[i][j])) {
                    num = 0;
                    bfs(i, j, num);
                    if (num != 0) {
                        arrayList.add(num);
                    }
                }
            }
        }

        if (arrayList.size() == 0) {
            return new int[]{-1};
        }
        //리스트를 오름차순으로 출력
        int[] answer = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }

    private static void bfs(int x, int y, int sum) {
        //sum 숫자를 집어넣고 X로 만들고 queue에 집어넣는다
        Queue<int[]> queue = new ArrayDeque<>();
        sum += Integer.parseInt(map[x][y]);
        map[x][y] = "X";
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            //BFS에서는 우하좌상을 탐색함.숫자가 있으면 미리 값 더하고 X로 바꾸고 큐에 집어넣는다
            for (int i = 0; i < 4; i++) {
                int nextX = current[0] + dx[i];
                int nextY = current[1] + dy[i];
                if (nextX >= 0 && nextX < map.length && nextY >= 0 && nextY < map[x].length && !"X".equals(map[nextX][nextY])) {
                    sum += Integer.parseInt(map[nextX][nextY]);
                    map[nextX][nextY] = "X";
                    queue.add(new int[]{nextX, nextY});
                }
            }
            num = sum;
        }
    }
}
